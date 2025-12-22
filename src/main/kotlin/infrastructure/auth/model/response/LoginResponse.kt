package infrastructure.auth.model.response

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val token: String,
)