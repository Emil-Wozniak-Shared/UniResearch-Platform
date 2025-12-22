package infrastructure.auth.model.event

data class LoginEvent(
    val username: String,
    val password: String
)
