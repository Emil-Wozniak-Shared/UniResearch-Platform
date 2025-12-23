package infrastructure.auth.port.out.persistence

import infrastructure.auth.model.event.FindWithRolesAndPermissionsEvent
import infrastructure.auth.model.result.FindWithRolesAndPermissionsResult

interface UserDetailsRepositoryPort {
    suspend fun findWithRolesAndPermissions(event: FindWithRolesAndPermissionsEvent): FindWithRolesAndPermissionsResult
}