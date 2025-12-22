package infrastructure.permission.model.command

import common.Pageable

data class ListPermissionCommand(
    val pageable: Pageable
)
