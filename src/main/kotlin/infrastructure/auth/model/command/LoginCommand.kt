package infrastructure.auth.model.command

data class LoginCommand(
    val username: String,
    val password: String
)
