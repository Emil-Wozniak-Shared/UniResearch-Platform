package infrastructure.permission.model.command

data class UpdatePermissionCommand(
    val entity: domain.permission.PermissionEntity
)
