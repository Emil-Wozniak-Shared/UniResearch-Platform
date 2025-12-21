package infrastructure.researchProgram.model.command

import domain.researchProgram.ResearchProgramEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class ListResearchProgramCommand(
    val pageable: pl.ejdev.common.Pageable
)
