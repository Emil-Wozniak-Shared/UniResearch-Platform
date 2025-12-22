package infrastructure.role.model.command

import kotlinx.serialization.Serializable

@Serializable
data class CreateRoleCommand(
    val entity: domain.role.RoleEntity
)
