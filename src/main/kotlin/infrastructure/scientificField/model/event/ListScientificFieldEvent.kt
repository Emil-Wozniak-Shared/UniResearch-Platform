package infrastructure.scientificField.model.event

import domain.scientificField.ScientificFieldEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class ListScientificFieldEvent(
    val pageable: pl.ejdev.common.Pageable
)
