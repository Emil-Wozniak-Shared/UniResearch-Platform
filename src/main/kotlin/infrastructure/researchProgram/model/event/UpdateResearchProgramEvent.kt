package infrastructure.researchProgram.model.event

import domain.researchProgram.ResearchProgramEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class UpdateResearchProgramEvent(
    val entity: domain.researchProgram.ResearchProgramEntity
)
