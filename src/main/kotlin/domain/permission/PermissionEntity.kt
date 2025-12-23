package domain.permission

import kotlinx.serialization.Serializable
import pl.ejdev.infrastructure.utils.serializer.UUIDSerializer
import java.util.UUID

@Serializable
data class PermissionEntity(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val name: String,
    val description: String
)

enum class Permission {
    READ_ALL,
    WRITE_ALL,
    EDIT_OWN,
    READ_OWN,
    GENERATE_REPORTS,
    APPROVE_CHANGES,
    VIEW_PUBLIC_DATA,
    AUDIT_LOGS;

    companion object {
        val allNotPublic: Array<Permission> =
            entries.filter { it != VIEW_PUBLIC_DATA }.toTypedArray()
    }
}