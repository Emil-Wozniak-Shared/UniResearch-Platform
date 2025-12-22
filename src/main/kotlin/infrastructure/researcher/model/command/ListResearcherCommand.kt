package infrastructure.researcher.model.command

import common.Pageable

data class ListResearcherCommand(
    val pageable: Pageable
)
