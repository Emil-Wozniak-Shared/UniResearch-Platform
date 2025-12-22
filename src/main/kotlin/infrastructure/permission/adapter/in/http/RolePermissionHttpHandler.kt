package infrastructure.permission.adapter.`in`.http

import infrastructure.permission.model.command.CreateRolePermissionCommand
import infrastructure.permission.model.command.DeleteRolePermissionCommand
import infrastructure.permission.model.command.FindRolePermissionCommand
import infrastructure.permission.model.command.ListRolePermissionsCommand
import infrastructure.permission.model.command.UpdateRolePermissionCommand
import infrastructure.permission.model.result.CreateRolePermissionResult
import infrastructure.permission.model.result.DeleteRolePermissionResult
import infrastructure.permission.model.result.FindRolePermissionResult
import infrastructure.permission.model.result.ListRolePermissionsResult
import infrastructure.permission.model.result.UpdateRolePermissionResult
import infrastructure.permission.port.`in`.http.RolePermissionHttpPort
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receive
import toPageable
import java.util.UUID

private const val ROLE_ID = "roleId"
private const val PERMISSION_ID = "permissionId"

class RolePermissionHttpHandler(private val httpPort: RolePermissionHttpPort) {
    suspend fun find(call: ApplicationCall): FindRolePermissionResult {
        return httpPort.find(
            FindRolePermissionCommand(
                UUID.fromString(call.parameters[ROLE_ID]),
                UUID.fromString(call.parameters[PERMISSION_ID])
            )
        )
    }

    suspend fun list(call: ApplicationCall): ListRolePermissionsResult =
        httpPort.list(
            ListRolePermissionsCommand(
                UUID.fromString(call.parameters[ROLE_ID]),
                call.toPageable()
            )
        )

    suspend fun create(call: ApplicationCall): CreateRolePermissionResult =
        httpPort.create(call.receive<CreateRolePermissionCommand>())

    suspend fun update(call: ApplicationCall): UpdateRolePermissionResult =
        httpPort.update(call.receive<UpdateRolePermissionCommand>())

    suspend fun delete(call: ApplicationCall): DeleteRolePermissionResult =
        httpPort.delete(
            DeleteRolePermissionCommand(
                UUID.fromString(call.parameters[ROLE_ID]),
                UUID.fromString(call.parameters[PERMISSION_ID])
            )
        )
}