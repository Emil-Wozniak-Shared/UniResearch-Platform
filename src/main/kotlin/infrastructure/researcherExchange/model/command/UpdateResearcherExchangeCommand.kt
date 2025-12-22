package infrastructure.researcherExchange.model.command

data class UpdateResearcherExchangeCommand(
    val entity: domain.researcherExchange.ResearcherExchangeEntity
)
