package infrastructure.researcher.model.command

import domain.researcher.ResearchProgramEntity

data class UpdateResearchProgramCommand(
    val entity: ResearchProgramEntity
)
