package infrastructure.researchProgram.model.command

import domain.researchProgram.ResearchProgramEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class CreateResearchProgramCommand(
    val entity: domain.researchProgram.ResearchProgramEntity
)
