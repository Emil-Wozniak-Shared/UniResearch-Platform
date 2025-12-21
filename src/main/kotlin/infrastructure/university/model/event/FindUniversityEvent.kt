package infrastructure.university.model.event

import domain.university.UniversityEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class FindUniversityEvent(
    val id: java.util.UUID
)
