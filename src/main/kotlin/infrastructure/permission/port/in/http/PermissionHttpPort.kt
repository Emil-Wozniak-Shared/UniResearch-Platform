package infrastructure.permission.port.`in`.http

import infrastructure.permission.model.command.CreatePermissionCommand
import infrastructure.permission.model.command.DeletePermissionCommand
import infrastructure.permission.model.command.FindPermissionCommand
import infrastructure.permission.model.command.ListPermissionCommand
import infrastructure.permission.model.command.UpdatePermissionCommand
import infrastructure.permission.model.result.CreatePermissionResult
import infrastructure.permission.model.result.DeletePermissionResult
import infrastructure.permission.model.result.FindPermissionResult
import infrastructure.permission.model.result.ListPermissionResult
import infrastructure.permission.model.result.UpdatePermissionResult

interface PermissionHttpPort {
    suspend fun find(command: FindPermissionCommand): FindPermissionResult
    suspend fun list(command: ListPermissionCommand): ListPermissionResult
    suspend fun create(command: CreatePermissionCommand): CreatePermissionResult
    suspend fun update(command: UpdatePermissionCommand): UpdatePermissionResult
    suspend fun delete(command: DeletePermissionCommand): DeletePermissionResult
}
