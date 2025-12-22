package infrastructure.permission.model.event

data class UpdatePermissionEvent(
    val entity: domain.permission.PermissionEntity
)
