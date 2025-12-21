package infrastructure.agency.model.command

import kotlinx.serialization.Serializable
import pl.ejdev.infrastructure.utils.serializer.UUIDSerializer

@Serializable
data class FindAgencyCommand(
    @Serializable(with = UUIDSerializer::class)
    val id: java.util.UUID
)
