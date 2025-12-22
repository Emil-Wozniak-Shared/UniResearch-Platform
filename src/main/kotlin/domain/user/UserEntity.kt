package domain.user

import kotlinx.serialization.Serializable
import pl.ejdev.infrastructure.utils.serializer.UUIDSerializer
import java.util.UUID

@Serializable
data class UserEntity(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val username: String,
    val email: String,
    val passwordHash: String,
    @Serializable(with = UUIDSerializer::class)
    val researcherId: UUID
)
