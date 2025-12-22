package infrastructure.grant.model.event

data class UpdateGrantEvent(
    val entity: domain.grant.GrantEntity
)
