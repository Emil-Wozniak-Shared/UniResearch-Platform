package infrastructure.role.port.out.persistence

import infrastructure.role.model.event.CreateRoleEvent
import infrastructure.role.model.event.DeleteRoleEvent
import infrastructure.role.model.event.FindRoleEvent
import infrastructure.role.model.event.ListRoleEvent
import infrastructure.role.model.event.UpdateRoleEvent
import infrastructure.role.model.result.CreateRoleResult
import infrastructure.role.model.result.DeleteRoleResult
import infrastructure.role.model.result.FindRoleResult
import infrastructure.role.model.result.ListRoleResult
import infrastructure.role.model.result.UpdateRoleResult

interface RolePersistencePort {
    suspend fun find(event: FindRoleEvent): FindRoleResult
    suspend fun list(event: ListRoleEvent): ListRoleResult
    suspend fun create(event: CreateRoleEvent): CreateRoleResult
    suspend fun update(event: UpdateRoleEvent): UpdateRoleResult
    suspend fun delete(event: DeleteRoleEvent): DeleteRoleResult
}
