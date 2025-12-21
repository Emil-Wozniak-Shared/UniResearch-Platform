package infrastructure.reagent.model.command

import domain.reagent.ReagentEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class FindReagentCommand(
    val id: java.util.UUID
)
