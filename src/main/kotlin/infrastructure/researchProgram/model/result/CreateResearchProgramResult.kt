package infrastructure.researchProgram.model.result

import domain.researchProgram.ResearchProgramEntity
import java.util.UUID

data class CreateResearchProgramResult(
    val entity: domain.researchProgram.ResearchProgramEntity
)
