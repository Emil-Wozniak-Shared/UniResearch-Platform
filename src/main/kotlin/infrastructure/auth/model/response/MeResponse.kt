package infrastructure.auth.model.response

import kotlinx.serialization.Serializable

@Serializable
data class MeResponse(
    val username: String,
    val roles: Set<MyRole>,
    val permissions: Set<MyPermission>,
) {
}

@Serializable
data class MyRole(
    val name: String,
    val description: String,
)

@Serializable
data class MyPermission(
    val name: String,
    val description: String,
)