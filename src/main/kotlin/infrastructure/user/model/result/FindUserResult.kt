package infrastructure.user.model.result

import domain.user.UserEntity
import java.util.UUID

data class FindUserResult(
    val entity: UserEntity?
)
