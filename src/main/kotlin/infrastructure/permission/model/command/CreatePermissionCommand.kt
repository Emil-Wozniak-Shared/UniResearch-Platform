package infrastructure.permission.model.command

data class CreatePermissionCommand(
    val entity: domain.permission.PermissionEntity
)
