package infrastructure.role.model.result

import kotlinx.serialization.Serializable

@Serializable
data class DeleteRoleResult(
    val deleted: Boolean
)
