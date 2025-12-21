package infrastructure.university.model.command

import domain.university.UniversityEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class DeleteUniversityCommand(
    val id: java.util.UUID
)
