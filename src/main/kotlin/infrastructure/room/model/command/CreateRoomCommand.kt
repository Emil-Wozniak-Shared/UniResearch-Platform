package infrastructure.room.model.command

data class CreateRoomCommand(
    val entity: domain.room.RoomEntity
)
