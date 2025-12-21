package infrastructure.researcherExchange.model.command

import domain.researcherExchange.ResearcherExchangeEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class ListResearcherExchangeCommand(
    val pageable: pl.ejdev.common.Pageable
)
