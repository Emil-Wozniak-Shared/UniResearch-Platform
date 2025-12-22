package infrastructure.user.port.`in`.http

import infrastructure.user.model.command.CreateUserRoleCommand
import infrastructure.user.model.command.DeleteUserRoleCommand
import infrastructure.user.model.command.FindUserRoleCommand
import infrastructure.user.model.command.ListUserRolesCommand
import infrastructure.user.model.command.UpdateUserRoleCommand
import infrastructure.user.model.result.CreateUserRoleResult
import infrastructure.user.model.result.DeleteUserRoleResult
import infrastructure.user.model.result.FindUserRoleResult
import infrastructure.user.model.result.ListUserRolesResult
import infrastructure.user.model.result.UpdateUserRoleResult

interface UserRoleHttpPort {
    suspend fun find(command: FindUserRoleCommand): FindUserRoleResult
    suspend fun list(command: ListUserRolesCommand): ListUserRolesResult
    suspend fun create(command: CreateUserRoleCommand): CreateUserRoleResult
    suspend fun update(command: UpdateUserRoleCommand): UpdateUserRoleResult
    suspend fun delete(command: DeleteUserRoleCommand): DeleteUserRoleResult
}