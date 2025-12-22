package infrastructure.location.model.event

data class CreateLocationEvent(
    val entity: domain.location.LocationEntity
)
