package domain.location

import java.util.UUID

data class LocationEntity(
    val id: UUID,
    val name: String,
    val type: String,
    val parentLocationId: UUID
)
