package infrastructure.building.model.command

data class CreateBuildingCommand(
    val entity: domain.building.BuildingEntity
)
