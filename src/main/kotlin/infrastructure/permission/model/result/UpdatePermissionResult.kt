package infrastructure.permission.model.result

import domain.permission.PermissionEntity
import java.util.UUID

data class UpdatePermissionResult(
    val entity: domain.permission.PermissionEntity
)
