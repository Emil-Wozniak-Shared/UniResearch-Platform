package infrastructure.researcherExchange.model.command

import domain.researcherExchange.ResearcherExchangeEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class CreateResearcherExchangeCommand(
    val entity: domain.researcherExchange.ResearcherExchangeEntity
)
