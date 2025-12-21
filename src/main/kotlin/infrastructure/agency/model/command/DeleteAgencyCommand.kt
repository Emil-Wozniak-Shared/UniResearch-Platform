package infrastructure.agency.model.command

import kotlinx.serialization.Serializable
import pl.ejdev.infrastructure.utils.serializer.UUIDSerializer
import java.util.*

@Serializable
data class DeleteAgencyCommand(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID
)
