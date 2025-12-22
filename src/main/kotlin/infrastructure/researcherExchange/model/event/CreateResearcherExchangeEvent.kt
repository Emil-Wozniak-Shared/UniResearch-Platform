package infrastructure.researcherExchange.model.event

data class CreateResearcherExchangeEvent(
    val entity: domain.researcherExchange.ResearcherExchangeEntity
)
