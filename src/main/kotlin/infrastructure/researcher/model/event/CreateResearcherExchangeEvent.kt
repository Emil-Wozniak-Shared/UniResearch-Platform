package infrastructure.researcher.model.event

import domain.researcherExchange.ResearcherExchangeEntity

data class CreateResearcherExchangeEvent(
    val entity: ResearcherExchangeEntity
)
