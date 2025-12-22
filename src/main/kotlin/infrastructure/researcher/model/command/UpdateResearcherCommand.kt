package infrastructure.researcher.model.command

data class UpdateResearcherCommand(
    val entity: domain.researcher.ResearcherEntity
)
