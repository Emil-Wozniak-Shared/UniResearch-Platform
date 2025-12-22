package infrastructure.researcher.model.command

import domain.researcherExchange.ResearcherExchangeEntity

data class CreateResearcherExchangeCommand(
    val entity: ResearcherExchangeEntity
)
