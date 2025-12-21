package infrastructure.scientificField.model.result

import domain.scientificField.ScientificFieldEntity
import java.util.UUID

data class ListScientificFieldResult(
    val entities: List<ScientificFieldEntity>
)
