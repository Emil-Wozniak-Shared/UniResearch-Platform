package infrastructure.role.adapter.out.persistence

import domain.role.RoleEntity
import infrastructure.role.model.event.*
import infrastructure.role.model.result.*
import infrastructure.role.port.out.persistence.RolePersistencePort
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

class RolePersistenceAdapter(
    private val db: Database
) : RolePersistencePort {

    override suspend fun find(event: FindRoleEvent): FindRoleResult = transaction(db) {
        Roles
            .select(Roles.columns)
            .where(Roles.id eq event.id)
            .firstOrNull()
            ?.toEntity()
            ?.let { FindRoleResult(it) }
            ?: throw NoSuchElementException("Role not found")
    }

    override suspend fun list(event: ListRoleEvent): ListRoleResult = transaction(db) {
        val offset = event.pageable.page * event.pageable.size
        val query = Roles.selectAll()
            .limit(event.pageable.size)
            .offset(offset.toLong())

        ListRoleResult(query.map { it.toEntity() })
    }

    override suspend fun create(event: CreateRoleEvent): CreateRoleResult = transaction(db) {
        val entity = event.entity
        Roles.insert {
            it[id] = entity.id
            it[name] = entity.name
            it[description] = entity.description
        }
        CreateRoleResult(entity)
    }

    override suspend fun update(event: UpdateRoleEvent): UpdateRoleResult = transaction(db) {
        val entity = event.entity
        val updated = Roles.update({ Roles.id eq entity.id }) {
            it[name] = entity.name
            it[description] = entity.description
        }
        if (updated == 0) throw NoSuchElementException("Role not found")
        UpdateRoleResult(entity)
    }

    override suspend fun delete(event: DeleteRoleEvent): DeleteRoleResult = transaction(db) {
        val deleted = Roles.deleteWhere { Roles.id eq event.id }
        DeleteRoleResult(deleted > 0)
    }

    private fun ResultRow.toEntity() = RoleEntity(
        id = this[Roles.id],
        name = this[Roles.name],
        description = this[Roles.description]
    )
}
