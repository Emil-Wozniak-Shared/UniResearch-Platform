package infrastructure.reagent.model.command

import common.Pageable

data class ListReagentCommand(
    val pageable: Pageable
)
