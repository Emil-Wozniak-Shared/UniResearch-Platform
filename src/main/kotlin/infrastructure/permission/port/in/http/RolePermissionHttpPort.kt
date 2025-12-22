package infrastructure.permission.port.`in`.http

import infrastructure.permission.model.command.CreateRolePermissionCommand
import infrastructure.permission.model.command.DeleteRolePermissionCommand
import infrastructure.permission.model.command.FindRolePermissionCommand
import infrastructure.permission.model.command.ListRolePermissionsCommand
import infrastructure.permission.model.command.UpdateRolePermissionCommand
import infrastructure.permission.model.result.CreateRolePermissionResult
import infrastructure.permission.model.result.DeleteRolePermissionResult
import infrastructure.permission.model.result.FindRolePermissionResult
import infrastructure.permission.model.result.ListRolePermissionsResult
import infrastructure.permission.model.result.UpdateRolePermissionResult

interface RolePermissionHttpPort {
    suspend fun find(command: FindRolePermissionCommand): FindRolePermissionResult
    suspend fun list(command: ListRolePermissionsCommand): ListRolePermissionsResult
    suspend fun create(command: CreateRolePermissionCommand): CreateRolePermissionResult
    suspend fun update(command: UpdateRolePermissionCommand): UpdateRolePermissionResult
    suspend fun delete(command: DeleteRolePermissionCommand): DeleteRolePermissionResult
}
