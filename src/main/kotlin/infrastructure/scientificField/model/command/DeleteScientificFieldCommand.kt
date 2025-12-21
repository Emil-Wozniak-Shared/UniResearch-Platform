package infrastructure.scientificField.model.command

import domain.scientificField.ScientificFieldEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class DeleteScientificFieldCommand(
    val id: java.util.UUID
)
