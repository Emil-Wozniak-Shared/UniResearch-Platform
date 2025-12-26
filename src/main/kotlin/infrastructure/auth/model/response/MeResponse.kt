package infrastructure.auth.model.response

import domain.permission.PermissionEntity
import domain.role.RoleEntity
import infrastructure.auth.model.result.FindWithRolesAndPermissionsResult
import kotlinx.serialization.Serializable

@Serializable
data class MeResponse(
    val username: String,
    val roles: Set<MyRole>,
    val permissions: Set<MyPermission>,
) {
    companion object {
        fun from(result: FindWithRolesAndPermissionsResult.Some): MeResponse =
            MeResponse(
                username = result.user.username,
                roles = result.roles
                    .map(MyRole::from)
                    .toSet(),
                permissions = result.permissions
                    .map(MyPermission::from)
                    .toSet(),
            )
    }
}

@Serializable
data class MyRole(
    val name: String,
    val description: String,
) {
    companion object {
        fun from(entity: RoleEntity): MyRole = MyRole(entity.name, entity.description)
    }
}

@Serializable
data class MyPermission(
    val name: String,
    val description: String,
) {
    companion object {
        fun from(entity: PermissionEntity): MyPermission =
            MyPermission(entity.name, entity.description)

    }
}