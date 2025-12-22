package infrastructure.role.model.command

data class UpdateRoleCommand(
    val entity: domain.role.RoleEntity
)
