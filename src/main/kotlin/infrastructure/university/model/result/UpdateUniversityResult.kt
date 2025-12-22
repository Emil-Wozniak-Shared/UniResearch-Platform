package infrastructure.university.model.result

import domain.university.UniversityEntity
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class UpdateUniversityResult(
    val entity: UniversityEntity
)
