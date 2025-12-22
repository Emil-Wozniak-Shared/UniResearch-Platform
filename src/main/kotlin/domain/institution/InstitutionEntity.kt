package domain.institution

import kotlinx.serialization.Serializable
import pl.ejdev.infrastructure.utils.serializer.UUIDSerializer
import java.util.*

@Serializable
data class InstitutionEntity(
    @Serializable(UUIDSerializer::class)
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val type: String,
    @Serializable(UUIDSerializer::class)
    val locationId: UUID,
    @Serializable(UUIDSerializer::class)
    val universityId: UUID,
    val foundedYear: Int,
    @Serializable(UUIDSerializer::class)
    val scientificFieldId: UUID,
)
