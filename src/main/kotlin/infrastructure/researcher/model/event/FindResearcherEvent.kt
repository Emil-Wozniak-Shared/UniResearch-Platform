package infrastructure.researcher.model.event

import domain.researcher.ResearcherEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class FindResearcherEvent(
    val id: java.util.UUID
)
