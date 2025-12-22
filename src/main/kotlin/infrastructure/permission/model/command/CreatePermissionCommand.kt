package infrastructure.permission.model.command

import kotlinx.serialization.Serializable

@Serializable
data class CreatePermissionCommand(
    val entity: domain.permission.PermissionEntity
)
