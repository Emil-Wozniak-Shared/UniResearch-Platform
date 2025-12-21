package infrastructure.building.model.command

import domain.building.BuildingEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class CreateBuildingCommand(
    val entity: domain.building.BuildingEntity
)
