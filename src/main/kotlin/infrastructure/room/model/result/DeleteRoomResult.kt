package infrastructure.room.model.result

import domain.room.RoomEntity
import java.util.UUID

data class DeleteRoomResult(
    val entity: RoomEntity?
)
