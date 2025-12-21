package infrastructure.researcherExchange.model.result

import domain.researcherExchange.ResearcherExchangeEntity
import java.util.UUID

data class FindResearcherExchangeResult(
    val entity: ResearcherExchangeEntity?
)
