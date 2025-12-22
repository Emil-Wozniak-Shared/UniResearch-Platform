package infrastructure.user.model.event

data class CreateUserEvent(
    val entity: domain.user.UserEntity
)
