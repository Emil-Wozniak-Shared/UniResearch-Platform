package infrastructure.university.model.command

import domain.university.UniversityEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class FindUniversityCommand(
    val id: java.util.UUID
)
