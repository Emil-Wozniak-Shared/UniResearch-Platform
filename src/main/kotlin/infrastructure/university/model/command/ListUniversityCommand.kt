package infrastructure.university.model.command

import domain.university.UniversityEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class ListUniversityCommand(
    val pageable: pl.ejdev.common.Pageable
)
