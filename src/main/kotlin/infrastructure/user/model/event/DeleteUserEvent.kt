package infrastructure.user.model.event

import domain.user.UserEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class DeleteUserEvent(
    val id: java.util.UUID
)
