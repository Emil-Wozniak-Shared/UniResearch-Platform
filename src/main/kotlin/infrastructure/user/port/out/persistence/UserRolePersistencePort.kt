package infrastructure.user.port.out.persistence

import infrastructure.user.model.event.CreateUserRoleEvent
import infrastructure.user.model.event.DeleteUserRoleEvent
import infrastructure.user.model.event.FindUserRoleEvent
import infrastructure.user.model.event.ListUserRolesEvent
import infrastructure.user.model.event.UpdateUserRoleEvent
import infrastructure.user.model.result.CreateUserRoleResult
import infrastructure.user.model.result.DeleteUserRoleResult
import infrastructure.user.model.result.FindUserRoleResult
import infrastructure.user.model.result.ListUserRolesResult
import infrastructure.user.model.result.UpdateUserRoleResult

interface UserRolePersistencePort {
    suspend fun find(event: FindUserRoleEvent): FindUserRoleResult
    suspend fun list(event: ListUserRolesEvent): ListUserRolesResult
    suspend fun create(event: CreateUserRoleEvent): CreateUserRoleResult
    suspend fun update(event: UpdateUserRoleEvent): UpdateUserRoleResult
    suspend fun delete(event: DeleteUserRoleEvent): DeleteUserRoleResult
}
