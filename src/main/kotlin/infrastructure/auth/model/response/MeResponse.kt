package infrastructure.auth.model.response

import kotlinx.serialization.Serializable
import pl.ejdev.infrastructure.utils.serializer.UUIDSerializer
import java.util.UUID

@Serializable
data class MeResponse(
    @Serializable(with = UUIDSerializer::class)
    val userId: UUID,
    val username: String,
    val roles: List<String>
) {
}