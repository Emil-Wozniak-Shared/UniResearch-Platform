package infrastructure.user.model.event

import domain.user.UserEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class FindUserEvent(
    val id: java.util.UUID
)
