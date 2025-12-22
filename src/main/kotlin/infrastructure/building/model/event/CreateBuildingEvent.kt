package infrastructure.building.model.event

data class CreateBuildingEvent(
    val entity: domain.building.BuildingEntity
)
