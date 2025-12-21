package infrastructure.reagent.model.result

import domain.reagent.ReagentEntity
import java.util.UUID

data class ListReagentResult(
    val entities: List<ReagentEntity>
)
