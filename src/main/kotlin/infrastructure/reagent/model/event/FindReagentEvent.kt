package infrastructure.reagent.model.event

import domain.reagent.ReagentEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class FindReagentEvent(
    val id: java.util.UUID
)
