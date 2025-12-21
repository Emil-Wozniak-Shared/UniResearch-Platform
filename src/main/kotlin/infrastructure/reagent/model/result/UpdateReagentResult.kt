package infrastructure.reagent.model.result

import domain.reagent.ReagentEntity
import java.util.UUID

data class UpdateReagentResult(
    val entity: domain.reagent.ReagentEntity
)
