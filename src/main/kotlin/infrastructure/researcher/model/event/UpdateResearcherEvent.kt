package infrastructure.researcher.model.event

data class UpdateResearcherEvent(
    val entity: domain.researcher.ResearcherEntity
)
