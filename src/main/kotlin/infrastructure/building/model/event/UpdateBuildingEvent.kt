package infrastructure.building.model.event

data class UpdateBuildingEvent(
    val entity: domain.building.BuildingEntity
)
