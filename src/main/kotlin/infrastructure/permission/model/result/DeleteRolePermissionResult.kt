package infrastructure.permission.model.result

import kotlinx.serialization.Serializable

@Serializable
data class DeleteRolePermissionResult(val success: Boolean)