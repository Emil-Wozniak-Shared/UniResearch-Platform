package infrastructure.role.model.result

import domain.role.RoleEntity
import java.util.UUID

data class ListRoleResult(
    val entities: List<RoleEntity>
)
