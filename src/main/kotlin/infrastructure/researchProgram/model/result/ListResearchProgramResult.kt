package infrastructure.researchProgram.model.result

import domain.researchProgram.ResearchProgramEntity
import java.util.UUID

data class ListResearchProgramResult(
    val entities: List<ResearchProgramEntity>
)
