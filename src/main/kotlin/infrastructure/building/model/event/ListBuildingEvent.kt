package infrastructure.building.model.event

import domain.building.BuildingEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class ListBuildingEvent(
    val pageable: pl.ejdev.common.Pageable
)
