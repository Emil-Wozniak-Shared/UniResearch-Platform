package infrastructure.researcher.model.command

import domain.researcher.ResearcherExchangeEntity

data class CreateResearcherExchangeCommand(
    val entity: ResearcherExchangeEntity
)
