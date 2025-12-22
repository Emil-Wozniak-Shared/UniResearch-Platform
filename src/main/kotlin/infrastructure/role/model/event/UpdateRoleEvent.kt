package infrastructure.role.model.event

data class UpdateRoleEvent(
    val entity: domain.role.RoleEntity
)
