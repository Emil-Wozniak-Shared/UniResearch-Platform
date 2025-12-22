package infrastructure.researchProgram.model.event

data class UpdateResearchProgramEvent(
    val entity: domain.researchProgram.ResearchProgramEntity
)
