package infrastructure.auth.model.event

import java.util.UUID
import pl.ejdev.common.Pageable
import domain.auth.AuthEntity

data class UpdateAuthEvent(
    val entity: domain.auth.AuthEntity
)
