package infrastructure.researcher.model.result

import domain.researcher.ResearcherEntity
import java.util.UUID

data class CreateResearcherResult(
    val entity: domain.researcher.ResearcherEntity
)
