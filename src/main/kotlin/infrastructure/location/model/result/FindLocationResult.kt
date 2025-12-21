package infrastructure.location.model.result

import domain.location.LocationEntity
import java.util.UUID

data class FindLocationResult(
    val entity: LocationEntity?
)
