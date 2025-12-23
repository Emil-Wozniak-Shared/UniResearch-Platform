package infrastructure.user.model.result

import domain.user.UserEntity
import kotlinx.serialization.Serializable

@Serializable
data class FindByUserResult(
    val user: UserEntity?
)
