package infrastructure.researcher.model.command

data class CreateResearcherCommand(
    val entity: domain.researcher.ResearcherEntity
)
