package infrastructure.grant.model.event

import domain.grant.GrantEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class DeleteGrantEvent(
    val id: java.util.UUID
)
