package infrastructure.researcher.model.result

import domain.researcherExchange.ResearcherExchangeEntity

data class ListResearcherExchangeResult(
    val entities: List<ResearcherExchangeEntity>
)
