package infrastructure.auth.model.command

import common.Pageable

data class ListAuthCommand(
    val pageable: Pageable
)
