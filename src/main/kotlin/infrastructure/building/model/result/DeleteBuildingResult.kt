package infrastructure.building.model.result

import domain.building.BuildingEntity
import java.util.UUID

data class DeleteBuildingResult(
    val entity: BuildingEntity?
)
