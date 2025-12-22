package infrastructure.user.model.command

import kotlinx.serialization.Serializable

@Serializable
data class UpdateUserCommand(
    val entity: domain.user.UserEntity
)
