package infrastructure.user.model.result

import domain.user.UserEntity
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class UpdateUserResult(
    val entity: UserEntity
)
