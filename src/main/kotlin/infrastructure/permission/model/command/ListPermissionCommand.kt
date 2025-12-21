package infrastructure.permission.model.command

import domain.permission.PermissionEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class ListPermissionCommand(
    val pageable: pl.ejdev.common.Pageable
)
