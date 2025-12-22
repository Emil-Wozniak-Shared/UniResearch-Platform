package infrastructure.researchProgram.model.command

data class UpdateResearchProgramCommand(
    val entity: domain.researchProgram.ResearchProgramEntity
)
