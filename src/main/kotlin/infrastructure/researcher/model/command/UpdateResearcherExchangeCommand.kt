package infrastructure.researcher.model.command

import domain.researcherExchange.ResearcherExchangeEntity

data class UpdateResearcherExchangeCommand(
    val entity: ResearcherExchangeEntity
)
