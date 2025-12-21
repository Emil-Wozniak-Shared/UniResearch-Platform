package infrastructure.scientificField.model.result

import domain.scientificField.ScientificFieldEntity
import java.util.UUID

data class UpdateScientificFieldResult(
    val entity: domain.scientificField.ScientificFieldEntity
)
