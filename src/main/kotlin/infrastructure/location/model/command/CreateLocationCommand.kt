package infrastructure.location.model.command

data class CreateLocationCommand(
    val entity: domain.location.LocationEntity
)
