package infrastructure.role.model.command

data class CreateRoleCommand(
    val entity: domain.role.RoleEntity
)
