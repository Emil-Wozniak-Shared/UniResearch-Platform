package infrastructure.grant.model.command

data class CreateGrantCommand(
    val entity: domain.grant.GrantEntity
)
