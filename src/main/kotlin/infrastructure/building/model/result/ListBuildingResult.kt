package infrastructure.building.model.result

import domain.building.BuildingEntity
import java.util.UUID

data class ListBuildingResult(
    val entities: List<BuildingEntity>
)
