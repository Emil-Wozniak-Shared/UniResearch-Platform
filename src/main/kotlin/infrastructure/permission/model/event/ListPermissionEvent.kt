package infrastructure.permission.model.event

import common.Pageable

data class ListPermissionEvent(
    val pageable: Pageable
)
