package infrastructure.user.model.result

import domain.permission.PermissionEntity
import domain.role.RoleEntity

data class ListEagerUserRolesResult(
    val roles: Set<RoleEntity>,
    val permissions: Set<PermissionEntity>,
)