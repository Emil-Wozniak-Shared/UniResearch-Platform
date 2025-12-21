package domain.user

import java.util.UUID

data class UserEntity(
    val id: UUID,
    val username: String,
    val email: String,
    val passwordHash: String,
    val researcherId: UUID
)
