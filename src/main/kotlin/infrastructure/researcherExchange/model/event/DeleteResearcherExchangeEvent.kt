package infrastructure.researcherExchange.model.event

import domain.researcherExchange.ResearcherExchangeEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class DeleteResearcherExchangeEvent(
    val id: java.util.UUID
)
