package infrastructure.researcherExchange.model.command

data class CreateResearcherExchangeCommand(
    val entity: domain.researcherExchange.ResearcherExchangeEntity
)
