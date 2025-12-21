package infrastructure.grant.model.event

import domain.grant.GrantEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class UpdateGrantEvent(
    val entity: domain.grant.GrantEntity
)
