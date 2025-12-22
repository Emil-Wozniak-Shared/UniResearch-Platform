package infrastructure.building.model.command

data class UpdateBuildingCommand(
    val entity: domain.building.BuildingEntity
)
