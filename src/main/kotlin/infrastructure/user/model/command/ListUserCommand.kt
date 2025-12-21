package infrastructure.user.model.command

import domain.user.UserEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class ListUserCommand(
    val pageable: pl.ejdev.common.Pageable
)
