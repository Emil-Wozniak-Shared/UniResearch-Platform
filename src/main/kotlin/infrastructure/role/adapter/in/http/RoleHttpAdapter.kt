package infrastructure.role.adapter.`in`.http

import infrastructure.role.model.command.CreateRoleCommand
import infrastructure.role.model.command.DeleteRoleCommand
import infrastructure.role.model.command.FindRoleCommand
import infrastructure.role.model.command.ListRoleCommand
import infrastructure.role.model.command.UpdateRoleCommand
import infrastructure.role.model.event.CreateRoleEvent
import infrastructure.role.model.event.DeleteRoleEvent
import infrastructure.role.model.event.FindRoleEvent
import infrastructure.role.model.event.ListRoleEvent
import infrastructure.role.model.event.UpdateRoleEvent
import infrastructure.role.model.result.CreateRoleResult
import infrastructure.role.model.result.DeleteRoleResult
import infrastructure.role.model.result.FindRoleResult
import infrastructure.role.model.result.ListRoleResult
import infrastructure.role.model.result.UpdateRoleResult
import infrastructure.role.port.`in`.http.RoleHttpPort
import infrastructure.role.port.out.persistence.RolePersistencePort

class RoleHttpAdapter(private val persistence: RolePersistencePort) : RoleHttpPort {

    override suspend fun find(command: FindRoleCommand): FindRoleResult =
        persistence.find(FindRoleEvent(command.id))

    override suspend fun list(command: ListRoleCommand): ListRoleResult =
        persistence.list(ListRoleEvent(command.pageable))

    override suspend fun create(command: CreateRoleCommand): CreateRoleResult =
        persistence.create(CreateRoleEvent(command.entity))

    override suspend fun update(command: UpdateRoleCommand): UpdateRoleResult =
        persistence.update(UpdateRoleEvent(command.entity))

    override suspend fun delete(command: DeleteRoleCommand): DeleteRoleResult =
        persistence.delete(DeleteRoleEvent(command.id))
}