package infrastructure.reagent.model.event

import domain.reagent.ReagentEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class DeleteReagentEvent(
    val id: java.util.UUID
)
