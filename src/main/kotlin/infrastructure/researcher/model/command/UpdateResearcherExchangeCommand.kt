package infrastructure.researcher.model.command

import domain.researcher.ResearcherExchangeEntity

data class UpdateResearcherExchangeCommand(
    val entity: ResearcherExchangeEntity
)
