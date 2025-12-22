package infrastructure.researcher.model.command

import domain.researchProgram.ResearchProgramEntity

data class CreateResearchProgramCommand(
    val entity: ResearchProgramEntity
)
