package domain.university

import kotlinx.serialization.Serializable
import pl.ejdev.infrastructure.utils.serializer.UUIDSerializer
import java.util.UUID

@Serializable
data class UniversityEntity(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val name: String,
    val type: String,
    @Serializable(with = UUIDSerializer::class)
    val locationId: UUID,
    val foundedYear: Int,
    @Serializable(with = UUIDSerializer::class)
    val scientificFieldId: UUID
)
