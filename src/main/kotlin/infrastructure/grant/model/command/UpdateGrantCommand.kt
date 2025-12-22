package infrastructure.grant.model.command

data class UpdateGrantCommand(
    val entity: domain.grant.GrantEntity
)
