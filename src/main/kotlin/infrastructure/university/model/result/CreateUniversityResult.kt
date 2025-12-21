package infrastructure.university.model.result

import domain.university.UniversityEntity
import java.util.UUID

data class CreateUniversityResult(
    val entity: domain.university.UniversityEntity
)
