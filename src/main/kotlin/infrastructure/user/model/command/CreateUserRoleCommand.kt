package infrastructure.user.model.command

import domain.user.UserRoleEntity

data class CreateUserRoleCommand(val entity: UserRoleEntity)