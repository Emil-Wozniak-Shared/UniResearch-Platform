package domain.auth

import java.util.UUID

data class AuthEntity(
    val id: UUID,
    val username: String,
    val email: String,
    val passwordHash: String
)
