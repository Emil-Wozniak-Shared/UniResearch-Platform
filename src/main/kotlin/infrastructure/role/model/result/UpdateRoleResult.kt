package infrastructure.role.model.result

import domain.role.RoleEntity
import java.util.UUID

data class UpdateRoleResult(
    val entity: domain.role.RoleEntity
)
