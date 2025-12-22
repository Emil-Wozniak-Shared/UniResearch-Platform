package infrastructure.researchProgram.model.command

import common.Pageable

data class ListResearchProgramCommand(
    val pageable: Pageable
)
