package infrastructure.user.port.`in`.http

import infrastructure.user.model.command.CreateUserCommand
import infrastructure.user.model.command.DeleteUserCommand
import infrastructure.user.model.command.FindUserCommand
import infrastructure.user.model.command.ListUserCommand
import infrastructure.user.model.command.UpdateUserCommand
import infrastructure.user.model.result.CreateUserResult
import infrastructure.user.model.result.DeleteUserResult
import infrastructure.user.model.result.FindUserResult
import infrastructure.user.model.result.ListUserResult
import infrastructure.user.model.result.UpdateUserResult

interface UserHttpPort {
    suspend fun find(command: FindUserCommand): FindUserResult
    suspend fun list(command: ListUserCommand): ListUserResult
    suspend fun create(command: CreateUserCommand): CreateUserResult
    suspend fun update(command: UpdateUserCommand): UpdateUserResult
    suspend fun delete(command: DeleteUserCommand): DeleteUserResult
}