package infrastructure.location.model.command

import domain.location.LocationEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class CreateLocationCommand(
    val entity: domain.location.LocationEntity
)
