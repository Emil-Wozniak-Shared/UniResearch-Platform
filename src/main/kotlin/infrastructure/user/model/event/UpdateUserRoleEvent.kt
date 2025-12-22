package infrastructure.user.model.event

import domain.user.UserRoleEntity

data class UpdateUserRoleEvent(val entity: UserRoleEntity)