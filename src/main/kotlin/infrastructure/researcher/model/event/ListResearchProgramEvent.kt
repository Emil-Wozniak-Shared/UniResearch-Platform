package infrastructure.researcher.model.event

import common.Pageable

data class ListResearchProgramEvent(
    val pageable: Pageable
)
