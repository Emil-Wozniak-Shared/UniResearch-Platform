package infrastructure.role.model.result

import domain.role.RoleEntity
import java.util.UUID

data class CreateRoleResult(
    val entity: domain.role.RoleEntity
)
