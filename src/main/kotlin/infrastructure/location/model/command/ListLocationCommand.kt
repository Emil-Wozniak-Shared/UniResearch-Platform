package infrastructure.location.model.command

import domain.location.LocationEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class ListLocationCommand(
    val pageable: pl.ejdev.common.Pageable
)
