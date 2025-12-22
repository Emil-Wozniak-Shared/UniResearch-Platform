package infrastructure.permission.port.out.persistence

import infrastructure.permission.model.event.CreatePermissionEvent
import infrastructure.permission.model.event.DeletePermissionEvent
import infrastructure.permission.model.event.FindPermissionEvent
import infrastructure.permission.model.event.ListPermissionEvent
import infrastructure.permission.model.event.UpdatePermissionEvent
import infrastructure.permission.model.result.CreatePermissionResult
import infrastructure.permission.model.result.DeletePermissionResult
import infrastructure.permission.model.result.FindPermissionResult
import infrastructure.permission.model.result.ListPermissionResult
import infrastructure.permission.model.result.UpdatePermissionResult

interface PermissionPersistencePort {
    suspend fun find(event: FindPermissionEvent): FindPermissionResult
    suspend fun list(event: ListPermissionEvent): ListPermissionResult
    suspend fun create(event: CreatePermissionEvent): CreatePermissionResult
    suspend fun update(event: UpdatePermissionEvent): UpdatePermissionResult
    suspend fun delete(event: DeletePermissionEvent): DeletePermissionResult
}