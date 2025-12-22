package infrastructure.role.model.command

import kotlinx.serialization.Serializable

@Serializable
data class UpdateRoleCommand(
    val entity: domain.role.RoleEntity
)
