package infrastructure.location.model.command

data class UpdateLocationCommand(
    val entity: domain.location.LocationEntity
)
