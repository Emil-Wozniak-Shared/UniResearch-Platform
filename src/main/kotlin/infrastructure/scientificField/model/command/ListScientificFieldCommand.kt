package infrastructure.scientificField.model.command

import common.Pageable

data class ListScientificFieldCommand(
    val pageable: Pageable
)
