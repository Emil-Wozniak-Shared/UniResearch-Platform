package infrastructure.researcher.model.event

import domain.researchProgram.ResearchProgramEntity

data class CreateResearchProgramEvent(
    val entity: ResearchProgramEntity
)
