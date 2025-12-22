package infrastructure.location.model.command

import common.Pageable

data class ListLocationCommand(
    val pageable: Pageable
)
