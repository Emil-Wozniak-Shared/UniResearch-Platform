package infrastructure.reagent.model.result

import domain.reagent.ReagentEntity
import java.util.UUID

data class DeleteReagentResult(
    val entity: ReagentEntity?
)
