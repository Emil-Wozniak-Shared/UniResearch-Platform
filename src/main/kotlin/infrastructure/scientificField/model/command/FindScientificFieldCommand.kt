package infrastructure.scientificField.model.command

import domain.scientificField.ScientificFieldEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class FindScientificFieldCommand(
    val id: java.util.UUID
)
