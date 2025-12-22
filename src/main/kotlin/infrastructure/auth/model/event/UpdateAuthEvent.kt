package infrastructure.auth.model.event

data class UpdateAuthEvent(
    val entity: domain.auth.AuthEntity
)
