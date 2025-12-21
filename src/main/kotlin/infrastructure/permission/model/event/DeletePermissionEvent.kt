package infrastructure.permission.model.event

import domain.permission.PermissionEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class DeletePermissionEvent(
    val id: java.util.UUID
)
