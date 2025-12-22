package infrastructure.role.adapter.`in`.http

import infrastructure.role.model.command.*
import infrastructure.role.model.result.*
import infrastructure.role.port.`in`.http.RoleHttpPort
import infrastructure.utils.routing.id
import io.ktor.server.request.*
import io.ktor.server.routing.*
import toPageable

class RoleHttpHandler(private val roleHttpPort: RoleHttpPort) {

    suspend fun find(call: RoutingCall): FindRoleResult =
        roleHttpPort.find(FindRoleCommand(call.parameters.id))

    suspend fun list(call: RoutingCall): ListRoleResult =
        roleHttpPort.list(ListRoleCommand(call.toPageable()))

    suspend fun create(call: RoutingCall): CreateRoleResult =
        roleHttpPort.create(call.receive<CreateRoleCommand>())

    suspend fun update(call: RoutingCall): UpdateRoleResult =
        roleHttpPort.update(call.receive<UpdateRoleCommand>())

    suspend fun delete(call: RoutingCall): DeleteRoleResult =
        roleHttpPort.delete(DeleteRoleCommand(call.parameters.id))
}