package infrastructure.auth.model.command

data class CreateAuthCommand(
    val entity: domain.auth.AuthEntity
)
