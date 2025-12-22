package domain.auth

import java.util.UUID

data class AuthEntity(
    val id: UUID = UUID.randomUUID(),
    val username: String,
    val email: String,
    val passwordHash: String
)
