package infrastructure.room.model.event

data class CreateRoomEvent(
    val entity: domain.room.RoomEntity
)
