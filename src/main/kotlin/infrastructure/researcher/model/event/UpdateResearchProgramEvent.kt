package infrastructure.researcher.model.event

import domain.researchProgram.ResearchProgramEntity

data class UpdateResearchProgramEvent(
    val entity: ResearchProgramEntity
)
