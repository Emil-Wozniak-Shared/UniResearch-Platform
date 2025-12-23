package infrastructure.researcher.model.command

import domain.researcher.ResearchProgramEntity

data class CreateResearchProgramCommand(
    val entity: ResearchProgramEntity
)
