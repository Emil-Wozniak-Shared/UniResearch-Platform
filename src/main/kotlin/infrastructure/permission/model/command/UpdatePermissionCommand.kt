package infrastructure.permission.model.command

import domain.permission.PermissionEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class UpdatePermissionCommand(
    val entity: domain.permission.PermissionEntity
)
