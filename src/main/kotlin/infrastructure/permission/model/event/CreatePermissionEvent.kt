package infrastructure.permission.model.event

data class CreatePermissionEvent(
    val entity: domain.permission.PermissionEntity
)
