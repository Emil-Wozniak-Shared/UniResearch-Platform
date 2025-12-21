package domain.institute

import java.util.UUID

data class InstituteEntity(
    val id: UUID,
    val name: String,
    val type: String,
    val locationId: UUID,
    val universityId: UUID,
    val foundedYear: Int,
    val scientificFieldId: UUID
)
