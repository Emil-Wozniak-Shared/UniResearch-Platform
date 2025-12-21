package domain.permission

import java.util.UUID

data class PermissionEntity(
    val id: UUID,
    val name: String,
    val description: String?
)
