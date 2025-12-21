package infrastructure.permission.model.event

import domain.permission.PermissionEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class UpdatePermissionEvent(
    val entity: domain.permission.PermissionEntity
)
