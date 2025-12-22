package infrastructure.location.model.event

data class UpdateLocationEvent(
    val entity: domain.location.LocationEntity
)
