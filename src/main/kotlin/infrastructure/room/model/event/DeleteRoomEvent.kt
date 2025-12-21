package infrastructure.room.model.event

import domain.room.RoomEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class DeleteRoomEvent(
    val id: java.util.UUID
)
