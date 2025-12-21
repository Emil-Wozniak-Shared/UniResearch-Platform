package infrastructure.scientificField.model.command

import domain.scientificField.ScientificFieldEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class ListScientificFieldCommand(
    val pageable: pl.ejdev.common.Pageable
)
