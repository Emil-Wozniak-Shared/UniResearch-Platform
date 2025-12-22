package infrastructure.role.model.event

data class CreateRoleEvent(
    val entity: domain.role.RoleEntity
)
