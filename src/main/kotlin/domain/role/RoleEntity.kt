package domain.role

import java.util.UUID

data class RoleEntity(
    val id: UUID,
    val name: String,
    val description: String?
)
