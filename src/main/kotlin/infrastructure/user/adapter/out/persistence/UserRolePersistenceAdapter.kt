package infrastructure.user.adapter.out.persistence

import domain.user.UserRoleEntity
import infrastructure.user.model.event.*
import infrastructure.user.model.result.*
import infrastructure.user.port.out.persistence.UserRolePersistencePort
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

class UserRolePersistenceAdapter(
    private val db: Database
) : UserRolePersistencePort {

    override suspend fun find(event: FindUserRoleEvent): FindUserRoleResult = transaction(db) {
        UserRoles.select((UserRoles.userId eq event.userId) and (UserRoles.roleId eq event.roleId))
            .firstOrNull()
            ?.toEntity()
            ?.let { FindUserRoleResult(it) }
            ?: throw NoSuchElementException("UserRole not found")
    }

    override suspend fun list(event: ListUserRolesEvent): ListUserRolesResult = transaction(db) {
        val offset = event.pageable.page * event.pageable.size
        val query = UserRoles
            .selectAll()
            .where(UserRoles.userId eq event.userId)
            .limit(event.pageable.size)
            .offset(offset.toLong())
        ListUserRolesResult(query.map { it.toEntity() })
    }

    override suspend fun create(event: CreateUserRoleEvent): CreateUserRoleResult = transaction(db) {
        val entity = event.entity
        UserRoles.insert {
            it[userId] = entity.userId
            it[roleId] = entity.roleId
        }
        CreateUserRoleResult(entity)
    }

    override suspend fun update(event: UpdateUserRoleEvent): UpdateUserRoleResult = transaction(db) {
        // Typically UserRole is just a mapping; update might not be needed
        val entity = event.entity
        val updated = UserRoles.update({
            (UserRoles.userId eq entity.userId) and (UserRoles.roleId eq entity.roleId)
        }) {}
        if (updated == 0) throw NoSuchElementException("UserRole not found")
        UpdateUserRoleResult(entity)
    }

    override suspend fun delete(event: DeleteUserRoleEvent): DeleteUserRoleResult = transaction(db) {
        val deleted = UserRoles.deleteWhere {
            (UserRoles.userId eq event.userId) and (UserRoles.roleId eq event.roleId)
        }
        DeleteUserRoleResult(deleted > 0)
    }

    private fun ResultRow.toEntity() = UserRoleEntity(
        userId = this[UserRoles.userId],
        roleId = this[UserRoles.roleId]
    )
}
