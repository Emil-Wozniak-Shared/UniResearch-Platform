package infrastructure.building.model.event

import domain.building.BuildingEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class UpdateBuildingEvent(
    val entity: domain.building.BuildingEntity
)
