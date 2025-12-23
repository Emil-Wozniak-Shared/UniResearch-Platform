package infrastructure.auth.model.result

import domain.permission.PermissionEntity
import domain.role.RoleEntity
import domain.user.UserEntity

sealed class FindWithRolesAndPermissionsResult {
    data class Some(
        val user: UserEntity,
        val roles: Set<RoleEntity>,
        val permissions: Set<PermissionEntity>,
    ) : FindWithRolesAndPermissionsResult()

    object None : FindWithRolesAndPermissionsResult()
}