package infrastructure.researchProgram.model.result

import domain.researchProgram.ResearchProgramEntity
import java.util.UUID

data class DeleteResearchProgramResult(
    val entity: ResearchProgramEntity?
)
