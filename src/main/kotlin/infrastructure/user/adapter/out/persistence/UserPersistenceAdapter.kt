package infrastructure.user.adapter.out.persistence

import domain.user.UserEntity
import infrastructure.user.model.event.CreateUserEvent
import infrastructure.user.model.event.DeleteUserEvent
import infrastructure.user.model.event.FindUserEvent
import infrastructure.user.model.event.ListUserEvent
import infrastructure.user.model.event.UpdateUserEvent
import infrastructure.user.model.result.*
import infrastructure.user.port.out.persistence.UserPersistencePort
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

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
        Users.selectAll().count()
        val offset = pageable.page * pageable.size

        val query = Users.selectAll()
            .limit(pageable.size)
            .offset(offset.toLong())

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

}
