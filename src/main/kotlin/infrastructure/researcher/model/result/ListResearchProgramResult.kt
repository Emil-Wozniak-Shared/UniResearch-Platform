package infrastructure.researcher.model.result

import domain.researchProgram.ResearchProgramEntity

data class ListResearchProgramResult(
    val entities: List<ResearchProgramEntity>
)
