package domain.institution

import java.util.*

data class InstitutionEntity(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val type: String,
    val locationId: UUID,
    val universityId: UUID,
    val foundedYear: Int,
    val scientificFieldId: UUID,
)
