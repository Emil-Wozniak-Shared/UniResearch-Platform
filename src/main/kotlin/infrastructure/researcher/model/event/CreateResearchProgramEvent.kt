package infrastructure.researcher.model.event

import domain.researcher.ResearchProgramEntity

data class CreateResearchProgramEvent(
    val entity: ResearchProgramEntity
)
