package infrastructure.room.model.command

data class UpdateRoomCommand(
    val entity: domain.room.RoomEntity
)
