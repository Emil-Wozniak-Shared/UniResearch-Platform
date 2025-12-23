package domain.user

import domain.role.Role

data class UserDetails(
    val id: String,
    val name: String,
    val roles: Set<Role>
)