package infrastructure.auth.model.event

import java.util.UUID
import pl.ejdev.common.Pageable
import domain.auth.AuthEntity

data class FindAuthEvent(
    val id: java.util.UUID
)
