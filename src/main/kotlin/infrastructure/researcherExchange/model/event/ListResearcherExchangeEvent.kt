package infrastructure.researcherExchange.model.event

import domain.researcherExchange.ResearcherExchangeEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class ListResearcherExchangeEvent(
    val pageable: pl.ejdev.common.Pageable
)
