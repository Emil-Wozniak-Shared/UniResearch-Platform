package infrastructure.permission.adapter.`in`.http

import infrastructure.permission.model.command.CreatePermissionCommand
import infrastructure.permission.model.command.DeletePermissionCommand
import infrastructure.permission.model.command.FindPermissionCommand
import infrastructure.permission.model.command.ListPermissionCommand
import infrastructure.permission.model.command.UpdatePermissionCommand
import infrastructure.permission.model.event.CreatePermissionEvent
import infrastructure.permission.model.event.DeletePermissionEvent
import infrastructure.permission.model.event.FindPermissionEvent
import infrastructure.permission.model.event.ListPermissionEvent
import infrastructure.permission.model.event.UpdatePermissionEvent
import infrastructure.permission.port.`in`.http.PermissionHttpPort
import infrastructure.permission.port.out.persistence.PermissionPersistencePort

class PermissionHttpAdapter(private val persistence: PermissionPersistencePort) : PermissionHttpPort {
    override suspend fun find(command: FindPermissionCommand) =
        persistence.find(FindPermissionEvent(command.id))

    override suspend fun list(command: ListPermissionCommand) =
        persistence.list(ListPermissionEvent(command.pageable))

    override suspend fun create(command: CreatePermissionCommand) =
        persistence.create(CreatePermissionEvent(command.entity))

    override suspend fun update(command: UpdatePermissionCommand) =
        persistence.update(UpdatePermissionEvent(command.entity))

    override suspend fun delete(command: DeletePermissionCommand) =
        persistence.delete(DeletePermissionEvent(command.id))
}
