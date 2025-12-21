package infrastructure.reagent.model.result

import domain.reagent.ReagentEntity
import java.util.UUID

data class CreateReagentResult(
    val entity: domain.reagent.ReagentEntity
)
