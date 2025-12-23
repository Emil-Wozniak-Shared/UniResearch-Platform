package domain.role

import kotlinx.serialization.Serializable
import pl.ejdev.infrastructure.utils.serializer.UUIDSerializer
import java.util.UUID

@Serializable
data class RoleEntity(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val name: String,
    val description: String
)
