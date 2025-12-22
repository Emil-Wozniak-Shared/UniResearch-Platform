package infrastructure.auth.model.command

data class UpdateAuthCommand(
    val entity: domain.auth.AuthEntity
)
