package infrastructure.user.model.event

data class UpdateUserEvent(
    val entity: domain.user.UserEntity
)
