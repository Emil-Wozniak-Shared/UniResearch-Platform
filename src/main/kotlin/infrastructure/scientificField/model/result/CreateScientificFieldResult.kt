package infrastructure.scientificField.model.result

import domain.scientificField.ScientificFieldEntity
import java.util.UUID

data class CreateScientificFieldResult(
    val entity: domain.scientificField.ScientificFieldEntity
)
