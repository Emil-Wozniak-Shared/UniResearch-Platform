package infrastructure.permission.model.result

import domain.permission.PermissionEntity
import java.util.UUID

data class DeletePermissionResult(
    val entity: PermissionEntity?
)
