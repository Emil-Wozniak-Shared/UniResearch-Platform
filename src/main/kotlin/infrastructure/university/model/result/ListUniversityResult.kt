package infrastructure.university.model.result

import domain.university.UniversityEntity
import java.util.UUID

data class ListUniversityResult(
    val entities: List<UniversityEntity>
)
