package infrastructure.permission.adapter.`in`.http

import infrastructure.permission.model.command.CreatePermissionCommand
import infrastructure.permission.model.command.DeletePermissionCommand
import infrastructure.permission.model.command.FindPermissionCommand
import infrastructure.permission.model.command.ListPermissionCommand
import infrastructure.permission.model.command.UpdatePermissionCommand
import infrastructure.permission.port.`in`.http.PermissionHttpPort
import io.ktor.server.request.receive
import io.ktor.server.routing.RoutingCall
import pl.ejdev.toPageable
import java.util.UUID

class PermissionHttpHandler(private val httpPort: PermissionHttpPort) {
    suspend fun find(call: RoutingCall) =
        httpPort.find(FindPermissionCommand(UUID.fromString(call.parameters["id"])))

    suspend fun list(call: RoutingCall) =
        httpPort.list(ListPermissionCommand(call.toPageable()))

    suspend fun create(call: RoutingCall) =
        httpPort.create(call.receive<CreatePermissionCommand>())

    suspend fun update(call: RoutingCall) =
        httpPort.update(call.receive<UpdatePermissionCommand>())

    suspend fun delete(call: RoutingCall) =
        httpPort.delete(DeletePermissionCommand(UUID.fromString(call.parameters["id"])))
}