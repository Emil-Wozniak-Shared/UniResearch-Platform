package infrastructure.permission.port.out.persistence

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

interface RolePermissionPersistencePort {
    suspend fun find(event: FindRolePermissionEvent): FindRolePermissionResult
    suspend fun list(event: ListRolePermissionsEvent): ListRolePermissionsResult
    suspend fun create(event: CreateRolePermissionEvent): CreateRolePermissionResult
    suspend fun update(event: UpdateRolePermissionEvent): UpdateRolePermissionResult
    suspend fun delete(event: DeleteRolePermissionEvent): DeleteRolePermissionResult
}