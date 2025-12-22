package infrastructure.room.model.event

data class UpdateRoomEvent(
    val entity: domain.room.RoomEntity
)
