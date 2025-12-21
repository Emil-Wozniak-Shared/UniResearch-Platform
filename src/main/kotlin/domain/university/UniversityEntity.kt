package domain.university

import java.util.UUID

data class UniversityEntity(
    val id: UUID,
    val name: String,
    val type: String,
    val locationId: UUID,
    val foundedYear: Int,
    val scientificFieldId: UUID
)
