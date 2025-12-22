package infrastructure.permission.adapter.out.persistence

import domain.role.RolePermissionEntity
import infrastructure.permission.model.event.CreateRolePermissionEvent
import infrastructure.permission.model.event.DeleteRolePermissionEvent
import infrastructure.permission.model.event.FindRolePermissionEvent
import infrastructure.permission.model.event.ListRolePermissionsEvent
import infrastructure.permission.model.event.UpdateRolePermissionEvent
import infrastructure.permission.model.result.CreateRolePermissionResult
import infrastructure.permission.model.result.DeleteRolePermissionResult
import infrastructure.permission.model.result.FindRolePermissionResult
import infrastructure.permission.model.result.ListRolePermissionsResult
import infrastructure.permission.model.result.UpdateRolePermissionResult
import infrastructure.permission.port.out.persistence.RolePermissionPersistencePort
import infrastructure.role.adapter.out.persistence.RolePermissions
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

class RolePermissionPersistenceAdapter(private val db: Database) : RolePermissionPersistencePort {

    override suspend fun find(event: FindRolePermissionEvent): FindRolePermissionResult = transaction(db) {
        RolePermissions.select (
            (RolePermissions.roleId eq event.roleId) and (RolePermissions.permissionId eq event.permissionId)
        ).firstOrNull()
            ?.toEntity()
            ?.let { FindRolePermissionResult(it) }
            ?: throw NoSuchElementException("RolePermission not found")
    }

    override suspend fun list(event: ListRolePermissionsEvent): ListRolePermissionsResult = transaction(db) {
        val offset = event.pageable.page * event.pageable.size
        val query = RolePermissions.select ( RolePermissions.roleId eq event.roleId )
            .limit(event.pageable.size)
            .offset(offset.toLong())
        ListRolePermissionsResult(query.map { it.toEntity() })
    }

    override suspend fun create(event: CreateRolePermissionEvent): CreateRolePermissionResult = transaction(db) {
        val entity = event.entity
        RolePermissions.insert {
            it[roleId] = entity.roleId
            it[permissionId] = entity.permissionId
        }
        CreateRolePermissionResult(entity)
    }

    override suspend fun update(event: UpdateRolePermissionEvent): UpdateRolePermissionResult = transaction(db) {
        // Typically RolePermission is just a mapping; update may not be needed
        val entity = event.entity
        val updated = RolePermissions.update({
            (RolePermissions.roleId eq entity.roleId) and (RolePermissions.permissionId eq entity.permissionId)
        }) {}
        if (updated == 0) throw NoSuchElementException("RolePermission not found")
        UpdateRolePermissionResult(entity)
    }

    override suspend fun delete(event: DeleteRolePermissionEvent): DeleteRolePermissionResult = transaction(db) {
        val deleted = RolePermissions.deleteWhere {
            (RolePermissions.roleId eq event.roleId) and (RolePermissions.permissionId eq event.permissionId)
        }
        DeleteRolePermissionResult(deleted > 0)
    }

    private fun ResultRow.toEntity() = RolePermissionEntity(
        roleId = this[RolePermissions.roleId],
        permissionId = this[RolePermissions.permissionId]
    )
}