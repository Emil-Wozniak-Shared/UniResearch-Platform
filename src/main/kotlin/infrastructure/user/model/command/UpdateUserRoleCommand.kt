package infrastructure.user.model.command

import domain.user.UserRoleEntity

data class UpdateUserRoleCommand(val entity: UserRoleEntity)