package infrastructure.researcher.model.command

import domain.researchProgram.ResearchProgramEntity

data class UpdateResearchProgramCommand(
    val entity: ResearchProgramEntity
)
