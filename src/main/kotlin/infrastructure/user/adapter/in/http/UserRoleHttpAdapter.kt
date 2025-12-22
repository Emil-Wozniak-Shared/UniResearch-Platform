package infrastructure.user.adapter.`in`.http

import infrastructure.user.model.command.CreateUserRoleCommand
import infrastructure.user.model.command.DeleteUserRoleCommand
import infrastructure.user.model.command.FindUserRoleCommand
import infrastructure.user.model.command.ListUserRolesCommand
import infrastructure.user.model.command.UpdateUserRoleCommand
import infrastructure.user.model.event.CreateUserRoleEvent
import infrastructure.user.model.event.DeleteUserRoleEvent
import infrastructure.user.model.event.FindUserRoleEvent
import infrastructure.user.model.event.ListUserRolesEvent
import infrastructure.user.model.event.UpdateUserRoleEvent
import infrastructure.user.port.`in`.http.UserRoleHttpPort
import infrastructure.user.port.out.persistence.UserRolePersistencePort

class UserRoleHttpAdapter(private val persistence: UserRolePersistencePort) : UserRoleHttpPort {
    override suspend fun find(command: FindUserRoleCommand) =
        persistence.find(FindUserRoleEvent(command.userId, command.roleId))

    override suspend fun list(command: ListUserRolesCommand) =
        persistence.list(ListUserRolesEvent(command.userId, command.pageable))

    override suspend fun create(command: CreateUserRoleCommand) =
        persistence.create(CreateUserRoleEvent(command.entity))

    override suspend fun update(command: UpdateUserRoleCommand) =
        persistence.update(UpdateUserRoleEvent(command.entity))

    override suspend fun delete(command: DeleteUserRoleCommand) =
        persistence.delete(DeleteUserRoleEvent(command.userId, command.roleId))
}