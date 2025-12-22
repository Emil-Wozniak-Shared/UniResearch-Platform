package infrastructure.researcherExchange.model.event

data class UpdateResearcherExchangeEvent(
    val entity: domain.researcherExchange.ResearcherExchangeEntity
)
