package infrastructure.permission.model.result

import domain.role.RolePermissionEntity
import kotlinx.serialization.Serializable

@Serializable
data class UpdateRolePermissionResult(val entity: RolePermissionEntity)