package domain.agency

import kotlinx.serialization.Serializable
import pl.ejdev.infrastructure.utils.serializer.UUIDSerializer
import java.util.UUID

@Serializable
data class AgencyEntity(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val type: String,
    val activity: String
)
