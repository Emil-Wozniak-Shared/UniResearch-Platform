package infrastructure.grant.model.event

data class CreateGrantEvent(
    val entity: domain.grant.GrantEntity
)
