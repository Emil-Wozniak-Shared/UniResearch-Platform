package infrastructure.room.model.command

import domain.room.RoomEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class ListRoomCommand(
    val pageable: pl.ejdev.common.Pageable
)
