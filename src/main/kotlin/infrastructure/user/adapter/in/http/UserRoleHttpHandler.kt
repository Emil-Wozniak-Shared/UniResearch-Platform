package infrastructure.user.adapter.`in`.http

import infrastructure.user.model.command.CreateUserRoleCommand
import infrastructure.user.model.command.DeleteUserRoleCommand
import infrastructure.user.model.command.FindUserRoleCommand
import infrastructure.user.model.command.ListUserRolesCommand
import infrastructure.user.model.command.UpdateUserRoleCommand
import infrastructure.user.port.`in`.http.UserRoleHttpPort
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receive
import toPageable
import java.util.UUID

class UserRoleHttpHandler(private val httpPort: UserRoleHttpPort) {
    suspend fun find(call: ApplicationCall) =
        httpPort.find(
            FindUserRoleCommand(
                UUID.fromString(call.parameters["userId"]),
                UUID.fromString(call.parameters["roleId"])
            )
        )

    suspend fun list(call: ApplicationCall) =
        httpPort.list(
            ListUserRolesCommand(
                UUID.fromString(call.parameters["userId"]),
                call.toPageable()
            )
        )

    suspend fun create(call: ApplicationCall) =
        httpPort.create(call.receive<CreateUserRoleCommand>())

    suspend fun update(call: ApplicationCall) =
        httpPort.update(call.receive<UpdateUserRoleCommand>())

    suspend fun delete(call: ApplicationCall) =
        httpPort.delete(
            DeleteUserRoleCommand(
                UUID.fromString(call.parameters["userId"]),
                UUID.fromString(call.parameters["roleId"])
            )
        )
}