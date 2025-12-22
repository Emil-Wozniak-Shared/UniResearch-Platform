package infrastructure.user.adapter.`in`.http

import infrastructure.user.model.command.*
import infrastructure.user.model.result.*
import infrastructure.user.port.`in`.http.UserHttpPort
import infrastructure.utils.routing.id
import io.ktor.server.request.*
import io.ktor.server.routing.*
import pl.ejdev.toPageable

class UserHttpHandler(private val userHttpPort: UserHttpPort) {

    suspend fun find(call: RoutingCall): FindUserResult =
        FindUserCommand(call.parameters.id).let { userHttpPort.find(it) }

    suspend fun list(call: RoutingCall): ListUserResult =
        ListUserCommand(call.toPageable()).let { userHttpPort.list(it) }

    suspend fun create(call: RoutingCall): CreateUserResult =
        call.receive<CreateUserCommand>().let { userHttpPort.create(it) }

    suspend fun update(call: RoutingCall): UpdateUserResult =
        call.receive<UpdateUserCommand>().let { userHttpPort.update(it) }

    suspend fun delete(call: RoutingCall): DeleteUserResult =
        DeleteUserCommand(call.parameters.id).let { userHttpPort.delete(it) }
}
