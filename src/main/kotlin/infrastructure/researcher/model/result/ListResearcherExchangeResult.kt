package infrastructure.researcher.model.result

import domain.researcher.ResearcherExchangeEntity

data class ListResearcherExchangeResult(
    val entities: List<ResearcherExchangeEntity>
)
