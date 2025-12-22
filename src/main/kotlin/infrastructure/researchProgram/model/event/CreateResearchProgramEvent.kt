package infrastructure.researchProgram.model.event

data class CreateResearchProgramEvent(
    val entity: domain.researchProgram.ResearchProgramEntity
)
