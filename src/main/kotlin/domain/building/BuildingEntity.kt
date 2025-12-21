package domain.building

import java.util.UUID

data class BuildingEntity(
    val id: UUID,
    val name: String,
    val address: String,
    val locationId: UUID,
    val universityId: UUID,
    val instituteId: UUID,
    val area: Double
)
