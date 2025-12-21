package infrastructure.scientificField.model.result

import domain.scientificField.ScientificFieldEntity
import java.util.UUID

data class DeleteScientificFieldResult(
    val entity: ScientificFieldEntity?
)
