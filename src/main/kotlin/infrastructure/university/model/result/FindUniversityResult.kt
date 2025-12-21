package infrastructure.university.model.result

import domain.university.UniversityEntity
import java.util.UUID

data class FindUniversityResult(
    val entity: UniversityEntity?
)
