package infrastructure.reagent.model.command

import domain.reagent.ReagentEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class UpdateReagentCommand(
    val entity: domain.reagent.ReagentEntity
)
