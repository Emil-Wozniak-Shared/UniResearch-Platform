package infrastructure.permission.model.result

import domain.role.RolePermissionEntity
import kotlinx.serialization.Serializable

@Serializable
data class ListRolePermissionsResult(val entities: List<RolePermissionEntity>)