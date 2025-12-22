package infrastructure.role.port.`in`.http

import infrastructure.role.model.command.CreateRoleCommand
import infrastructure.role.model.command.DeleteRoleCommand
import infrastructure.role.model.command.FindRoleCommand
import infrastructure.role.model.command.ListRoleCommand
import infrastructure.role.model.command.UpdateRoleCommand
import infrastructure.role.model.result.CreateRoleResult
import infrastructure.role.model.result.DeleteRoleResult
import infrastructure.role.model.result.FindRoleResult
import infrastructure.role.model.result.ListRoleResult
import infrastructure.role.model.result.UpdateRoleResult

interface RoleHttpPort {
    suspend fun find(command: FindRoleCommand): FindRoleResult
    suspend fun list(command: ListRoleCommand): ListRoleResult
    suspend fun create(command: CreateRoleCommand): CreateRoleResult
    suspend fun update(command: UpdateRoleCommand): UpdateRoleResult
    suspend fun delete(command: DeleteRoleCommand): DeleteRoleResult
}
