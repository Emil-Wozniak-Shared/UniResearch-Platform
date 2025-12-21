package infrastructure.location.model.event

import domain.location.LocationEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class DeleteLocationEvent(
    val id: java.util.UUID
)
