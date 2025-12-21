package domain.room

import java.util.UUID

data class RoomEntity(
    val id: UUID,
    val number: String,
    val type: String,
    val buildingId: UUID,
    val area: Double
)
