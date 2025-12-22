package infrastructure.room.model.command

import common.Pageable

data class ListRoomCommand(
    val pageable: Pageable
)
