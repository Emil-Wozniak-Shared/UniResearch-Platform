package infrastructure.permission.adapter.`in`.http

import infrastructure.permission.model.command.CreateRolePermissionCommand
import infrastructure.permission.model.command.DeleteRolePermissionCommand
import infrastructure.permission.model.command.FindRolePermissionCommand
import infrastructure.permission.model.command.ListRolePermissionsCommand
import infrastructure.permission.model.command.UpdateRolePermissionCommand
import infrastructure.permission.model.event.CreateRolePermissionEvent
import infrastructure.permission.model.event.DeleteRolePermissionEvent
import infrastructure.permission.model.event.FindRolePermissionEvent
import infrastructure.permission.model.event.ListRolePermissionsEvent
import infrastructure.permission.model.event.UpdateRolePermissionEvent
import infrastructure.permission.port.`in`.http.RolePermissionHttpPort
import infrastructure.permission.port.out.persistence.RolePermissionPersistencePort

class RolePermissionHttpAdapter(private val persistence: RolePermissionPersistencePort) : RolePermissionHttpPort {
    override suspend fun find(command: FindRolePermissionCommand) =
        persistence.find(FindRolePermissionEvent(command.roleId, command.permissionId))

    override suspend fun list(command: ListRolePermissionsCommand) =
        persistence.list(ListRolePermissionsEvent(command.roleId, command.pageable))

    override suspend fun create(command: CreateRolePermissionCommand) =
        persistence.create(CreateRolePermissionEvent(command.entity))

    override suspend fun update(command: UpdateRolePermissionCommand) =
        persistence.update(UpdateRolePermissionEvent(command.entity))

    override suspend fun delete(command: DeleteRolePermissionCommand) =
        persistence.delete(DeleteRolePermissionEvent(command.roleId, command.permissionId))
}

