package infrastructure.auth.model.event

import common.Pageable

data class ListAuthEvent(
    val pageable: Pageable
)
