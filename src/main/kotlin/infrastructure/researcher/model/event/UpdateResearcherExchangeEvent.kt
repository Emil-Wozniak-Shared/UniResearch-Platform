package infrastructure.researcher.model.event

import domain.researcherExchange.ResearcherExchangeEntity

data class UpdateResearcherExchangeEvent(
    val entity: ResearcherExchangeEntity
)
