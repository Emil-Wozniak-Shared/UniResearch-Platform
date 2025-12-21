package infrastructure.university.model.event

import domain.university.UniversityEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class CreateUniversityEvent(
    val entity: domain.university.UniversityEntity
)
