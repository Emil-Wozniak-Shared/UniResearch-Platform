package infrastructure.role.model.result

import domain.role.RoleEntity
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class ListRoleResult(
    val entities: List<RoleEntity>
)
