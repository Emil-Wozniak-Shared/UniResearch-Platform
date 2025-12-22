package domain.user

import java.util.UUID

data class UserRoleEntity(
    val userId: UUID,
    val roleId: UUID
)