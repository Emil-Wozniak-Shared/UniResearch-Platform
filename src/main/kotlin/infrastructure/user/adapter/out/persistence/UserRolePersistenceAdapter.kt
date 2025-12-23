package infrastructure.user.adapter.out.persistence

import domain.permission.PermissionEntity
import domain.role.RoleEntity
import domain.role.RolePermissionEntity
import domain.user.UserRoleEntity
import infrastructure.permission.adapter.out.persistence.Permissions
import infrastructure.role.adapter.out.persistence.RolePermissions
import infrastructure.role.adapter.out.persistence.Roles
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
        UserRoles
            .select(UserRoles.columns)
            .where((UserRoles.userId eq event.userId) and (UserRoles.roleId eq event.roleId))
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

    override suspend fun listEager(event: ListEagerUserRolesEvent, tx: Transaction): ListEagerUserRolesResult {
        val offset = event.pageable.page * event.pageable.size
        val userRoleEntities = UserRoles
            .selectAll()
            .where(UserRoles.userId eq event.userId)
            .limit(event.pageable.size)
            .offset(offset.toLong())
            .map { it.toEntity() }
        val rolesPermissions = userRoleEntities.flatMap { (_, roleId) ->
            RolePermissions
                .select(RolePermissions.columns)
                .where { RolePermissions.roleId eq roleId }
                .map { it.toRolePermissionEntity() }
        }.toSet()
        val roles = rolesPermissions.flatMap { (roleId, _) ->
            Roles.select(Roles.columns)
                .where { Roles.id eq roleId }
                .map { it.toRoleEntity() }
        }.toSet()
        val permissions = rolesPermissions.flatMap { (_, permissionId) ->
            Permissions.select(Permissions.columns)
                .where { Permissions.id eq permissionId }
                .map { it.toPermissionEntity() }
        }.toSet()

        return ListEagerUserRolesResult(
            roles = roles,
            permissions = permissions
        )
    }

    private fun ResultRow.toRolePermissionEntity() = RolePermissionEntity(
        this[RolePermissions.roleId],
        this[RolePermissions.permissionId]
    )

    private fun ResultRow.toRoleEntity() = RoleEntity(
        id = this[Roles.id],
        name = this[Roles.name],
        description = this[Roles.description]
    )

    private fun ResultRow.toPermissionEntity() = PermissionEntity(
        id = this[Permissions.id],
        name = this[Permissions.name],
        description = this[Permissions.description]
    )

    private fun ResultRow.toEntity() = UserRoleEntity(
        userId = this[UserRoles.userId],
        roleId = this[UserRoles.roleId]
    )
}
