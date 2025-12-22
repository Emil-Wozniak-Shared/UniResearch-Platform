package infrastructure.user.model.command

data class UpdateUserCommand(
    val entity: domain.user.UserEntity
)
