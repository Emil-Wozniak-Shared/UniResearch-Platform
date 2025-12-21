package infrastructure.permission.model.command

import domain.permission.PermissionEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class DeletePermissionCommand(
    val id: java.util.UUID
)
