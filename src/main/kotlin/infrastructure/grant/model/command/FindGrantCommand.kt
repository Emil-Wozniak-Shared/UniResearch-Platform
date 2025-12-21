package infrastructure.grant.model.command

import domain.grant.GrantEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class FindGrantCommand(
    val id: java.util.UUID
)
