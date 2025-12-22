package infrastructure.university.model.result

import kotlinx.serialization.Serializable

@Serializable
data class DeleteUniversityResult(
    val deleted: Boolean,
)
