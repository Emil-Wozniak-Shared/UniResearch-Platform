package infrastructure.location.model.result

import domain.location.LocationEntity
import java.util.UUID

data class CreateLocationResult(
    val entity: domain.location.LocationEntity
)
