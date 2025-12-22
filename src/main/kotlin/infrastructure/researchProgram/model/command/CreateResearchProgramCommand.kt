package infrastructure.researchProgram.model.command

data class CreateResearchProgramCommand(
    val entity: domain.researchProgram.ResearchProgramEntity
)
