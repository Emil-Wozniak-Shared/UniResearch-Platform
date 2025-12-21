package infrastructure.room.model.result

import domain.room.RoomEntity
import java.util.UUID

data class ListRoomResult(
    val entities: List<RoomEntity>
)
