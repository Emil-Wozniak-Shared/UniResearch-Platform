package infrastructure.permission.model.result

import domain.role.RolePermissionEntity
import kotlinx.serialization.Serializable

@Serializable
data class CreateRolePermissionResult(val entity: RolePermissionEntity)