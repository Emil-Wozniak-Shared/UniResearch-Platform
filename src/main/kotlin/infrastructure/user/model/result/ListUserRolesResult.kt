package infrastructure.user.model.result

import domain.user.UserRoleEntity

data class ListUserRolesResult(
    val entities: List<UserRoleEntity>
)