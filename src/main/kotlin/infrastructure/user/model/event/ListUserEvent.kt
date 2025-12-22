package infrastructure.user.model.event

import common.Pageable

data class ListUserEvent(
    val pageable: Pageable
)
