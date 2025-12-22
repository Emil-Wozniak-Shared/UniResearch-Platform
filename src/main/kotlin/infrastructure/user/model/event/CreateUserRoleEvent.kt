package infrastructure.user.model.event

import domain.user.UserRoleEntity

data class CreateUserRoleEvent(val entity: UserRoleEntity)