package infrastructure.grant.model.command

import domain.grant.GrantEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class ListGrantCommand(
    val pageable: pl.ejdev.common.Pageable
)
