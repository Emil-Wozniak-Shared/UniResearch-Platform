package domain.user

import domain.permission.Permission
import domain.role.Role

data class UserDetails(
    val name: String,
    val roles: Set<Role>,
    val permissions: Set<Permission>
)