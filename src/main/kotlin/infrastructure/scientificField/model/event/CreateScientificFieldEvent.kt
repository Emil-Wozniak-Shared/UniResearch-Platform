package infrastructure.scientificField.model.event

import domain.scientificField.ScientificFieldEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class CreateScientificFieldEvent(
    val entity: domain.scientificField.ScientificFieldEntity
)
