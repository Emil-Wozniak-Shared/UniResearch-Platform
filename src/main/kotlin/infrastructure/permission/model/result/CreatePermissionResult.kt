package infrastructure.permission.model.result

import domain.permission.PermissionEntity
import java.util.UUID

data class CreatePermissionResult(
    val entity: domain.permission.PermissionEntity
)
