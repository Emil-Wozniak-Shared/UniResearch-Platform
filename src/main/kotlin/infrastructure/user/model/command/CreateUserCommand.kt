package infrastructure.user.model.command

import kotlinx.serialization.Serializable

@Serializable
data class CreateUserCommand(
    val entity: domain.user.UserEntity
)
