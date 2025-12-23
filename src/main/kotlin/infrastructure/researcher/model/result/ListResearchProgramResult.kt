package infrastructure.researcher.model.result

import domain.researcher.ResearchProgramEntity

data class ListResearchProgramResult(
    val entities: List<ResearchProgramEntity>
)
