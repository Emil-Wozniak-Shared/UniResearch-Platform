package infrastructure.researcher.model.command

import domain.researcher.ResearcherEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class DeleteResearcherCommand(
    val id: java.util.UUID
)
