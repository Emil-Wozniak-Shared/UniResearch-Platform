package infrastructure.researcherExchange.model.command

import common.Pageable

data class ListResearcherExchangeCommand(
    val pageable: Pageable
)
