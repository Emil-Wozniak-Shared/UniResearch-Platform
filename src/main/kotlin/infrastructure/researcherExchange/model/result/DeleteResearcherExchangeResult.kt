package infrastructure.researcherExchange.model.result

import domain.researcherExchange.ResearcherExchangeEntity
import java.util.UUID

data class DeleteResearcherExchangeResult(
    val entity: ResearcherExchangeEntity?
)
