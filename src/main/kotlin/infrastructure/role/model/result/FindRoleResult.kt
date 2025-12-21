package infrastructure.role.model.result

import domain.role.RoleEntity
import java.util.UUID

data class FindRoleResult(
    val entity: RoleEntity?
)
