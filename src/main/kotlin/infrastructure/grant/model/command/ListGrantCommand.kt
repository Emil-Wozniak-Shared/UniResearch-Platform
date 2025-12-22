package infrastructure.grant.model.command

import common.Pageable

data class ListGrantCommand(
    val pageable: Pageable
)
