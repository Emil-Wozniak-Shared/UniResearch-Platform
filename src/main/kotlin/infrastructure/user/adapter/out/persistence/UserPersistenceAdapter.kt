package infrastructure.user.adapter.out.persistence

import common.Filter
import common.FilterOp
import domain.user.UserEntity
import infrastructure.user.model.event.*
import infrastructure.user.model.result.*
import infrastructure.user.port.out.persistence.UserPersistencePort
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.SqlExpressionBuilder.like
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

class UserPersistenceAdapter(
    private val db: Database
) : UserPersistencePort {

    override suspend fun find(event: FindUserEvent): FindUserResult = transaction(db) {
        Users.select(Users.id eq event.id)
            .firstOrNull()
            ?.toEntity()
            ?.let { FindUserResult(it) }
            ?: throw NoSuchElementException("User not found")
    }

    override suspend fun list(event: ListUserEvent): ListUserResult = transaction(db) {
        val (pageable) = event
        val offset = pageable.page * pageable.size
        val query = Users.selectAll()
            .limit(pageable.size)
            .offset(offset.toLong())
            .apply {
                if (pageable.filters.isNotEmpty()) {
                    adjustWhere { buildUserFilters(pageable.filters) }
                }
            }

        val entities = query.map { it.toEntity() }

        ListUserResult(entities)
    }

    override suspend fun create(event: CreateUserEvent): CreateUserResult = transaction(db) {
        val entity = event.entity
        val id = Users.insert {
            it[Users.username] = entity.username
            it[Users.email] = entity.email
            it[Users.passwordHash] = entity.passwordHash
            it[Users.researcherId] = entity.researcherId
        }[Users.id]
        CreateUserResult(entity.copy(id = id))
    }

    override suspend fun update(event: UpdateUserEvent): UpdateUserResult = transaction(db) {
        val entity = event.entity
        val updated = Users.update({ Users.id eq entity.id }) {
            it[Users.id] = entity.id
            it[Users.username] = entity.username
            it[Users.email] = entity.email
            it[Users.passwordHash] = entity.passwordHash
            it[Users.researcherId] = entity.researcherId
        }
        if (updated == 0) throw NoSuchElementException("User not found")
        UpdateUserResult(entity)
    }

    override suspend fun delete(event: DeleteUserEvent): DeleteUserResult = transaction(db) {
        DeleteUserResult(Users.deleteWhere { Users.id eq id } > 0)
    }

    private fun ResultRow.toEntity() = UserEntity(
        id = this[Users.id],
        username = this[Users.username],
        email = this[Users.email],
        passwordHash = this[Users.passwordHash],
        researcherId = this[Users.researcherId]
    )

    @Suppress("UNCHECKED_CAST")
    private fun buildUserFilters(filters: List<Filter>): Op<Boolean> {
        val ops: List<Op<Boolean>> = filters.mapNotNull { (field, op, value) ->
            val column = filterColumns[field] ?: return@mapNotNull null

            when (op) {
                FilterOp.EQ -> {
                    when (column.columnType) {
                        is UUIDColumnType -> (column as Column<UUID>) eq UUID.fromString(value)
                        is VarCharColumnType,
                        is TextColumnType -> (column as Column<String>) eq value

                        else -> null
                    }
                }
                FilterOp.LIKE -> {
                    when (column.columnType) {
                        is UUIDColumnType -> (column as Column<UUID>) eq UUID.fromString(value)
                        is VarCharColumnType,
                        is TextColumnType -> (column as Column<String>) like "%$value%"

                        else -> null
                    }
                }
            }

        }

        return ops.reduceOrNull { acc, op -> acc and op } ?: Op.TRUE
    }

    private val filterColumns: Map<String, Column<*>> = Users.columns.associateBy { it.name }


}
