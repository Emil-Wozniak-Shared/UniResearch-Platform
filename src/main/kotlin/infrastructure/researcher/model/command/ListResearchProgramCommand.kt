package infrastructure.researcher.model.command

import common.Pageable

data class ListResearchProgramCommand(
    val pageable: Pageable
)
