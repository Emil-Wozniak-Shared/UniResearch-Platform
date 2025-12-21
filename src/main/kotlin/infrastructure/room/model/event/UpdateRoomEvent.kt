package infrastructure.room.model.event

import domain.room.RoomEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class UpdateRoomEvent(
    val entity: domain.room.RoomEntity
)
