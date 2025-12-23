package infrastructure.researcher.model.event

import domain.researcher.ResearcherExchangeEntity

data class CreateResearcherExchangeEvent(
    val entity: ResearcherExchangeEntity
)
