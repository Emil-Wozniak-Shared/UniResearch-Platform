package infrastructure.room.model.command

import domain.room.RoomEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class CreateRoomCommand(
    val entity: domain.room.RoomEntity
)
