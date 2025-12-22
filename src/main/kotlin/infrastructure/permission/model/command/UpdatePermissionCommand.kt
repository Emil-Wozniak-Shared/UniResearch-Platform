package infrastructure.permission.model.command

import kotlinx.serialization.Serializable

@Serializable
data class UpdatePermissionCommand(
    val entity: domain.permission.PermissionEntity
)
