package infrastructure.user.adapter.`in`.http

import infrastructure.user.model.command.*
import infrastructure.user.model.event.*
import infrastructure.user.model.result.*
import infrastructure.user.port.`in`.http.UserHttpPort
import infrastructure.user.port.out.persistence.UserPersistencePort

class UserHttpAdapter(private val persistence: UserPersistencePort) : UserHttpPort {

    override suspend fun find(command: FindUserCommand): FindUserResult =
        FindUserEvent(command.id).let { persistence.find(it) }

    override suspend fun list(command: ListUserCommand): ListUserResult =
        ListUserEvent(command.pageable).let { persistence.list(it) }

    override suspend fun create(command: CreateUserCommand): CreateUserResult =
        CreateUserEvent(command.entity).let { persistence.create(it) }

    override suspend fun update(command: UpdateUserCommand): UpdateUserResult =
        UpdateUserEvent(command.entity).let {persistence.update(it)}

    override suspend fun delete(command: DeleteUserCommand): DeleteUserResult=
        DeleteUserEvent(command.id).let { persistence.delete(it) }
}
