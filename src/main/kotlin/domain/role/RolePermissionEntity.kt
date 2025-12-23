package domain.role

import kotlinx.serialization.Serializable
import pl.ejdev.infrastructure.utils.serializer.UUIDSerializer
import java.util.UUID

@Serializable
data class RolePermissionEntity(
    @Serializable(with = UUIDSerializer::class)
    val roleId: UUID,
    @Serializable(with = UUIDSerializer::class)
    val permissionId: UUID
)

enum class Role {
    IT_ADMIN,
    MINISTRY,
    UNIVERSITY,
    ACADEMY_INSTITUTE,
    DEPARTMENT_UNIT,
    PUBLIC_USER,
    AUDITOR,
    MODERATOR
}