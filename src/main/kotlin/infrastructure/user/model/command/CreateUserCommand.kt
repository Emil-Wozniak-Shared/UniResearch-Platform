package infrastructure.user.model.command

data class CreateUserCommand(
    val entity: domain.user.UserEntity
)
