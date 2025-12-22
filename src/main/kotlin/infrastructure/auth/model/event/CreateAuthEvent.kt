package infrastructure.auth.model.event

data class CreateAuthEvent(
    val entity: domain.auth.AuthEntity
)
