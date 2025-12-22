package infrastructure.researcher.model.event

data class CreateResearcherEvent(
    val entity: domain.researcher.ResearcherEntity
)
