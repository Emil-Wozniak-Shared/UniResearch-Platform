package infrastructure.researcher.model.command

import common.Pageable

data class ListResearcherExchangeCommand(
    val pageable: Pageable
)
