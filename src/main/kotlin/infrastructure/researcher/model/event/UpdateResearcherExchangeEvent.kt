package infrastructure.researcher.model.event

import domain.researcher.ResearcherExchangeEntity

data class UpdateResearcherExchangeEvent(
    val entity: ResearcherExchangeEntity
)
