package infrastructure.room.model.result

import domain.room.RoomEntity
import java.util.UUID

data class CreateRoomResult(
    val entity: domain.room.RoomEntity
)
