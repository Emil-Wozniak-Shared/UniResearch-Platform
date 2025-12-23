package infrastructure.researcher.model.event

import domain.researcher.ResearchProgramEntity

data class UpdateResearchProgramEvent(
    val entity: ResearchProgramEntity
)
