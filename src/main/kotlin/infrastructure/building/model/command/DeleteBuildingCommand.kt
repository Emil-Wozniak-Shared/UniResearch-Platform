package infrastructure.building.model.command

import domain.building.BuildingEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class DeleteBuildingCommand(
    val id: java.util.UUID
)
