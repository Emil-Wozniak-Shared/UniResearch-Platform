package configuration

import com.auth0.jwt.impl.JWTParser
import domain.permission.Permission
import domain.role.Role
import domain.user.UserDetails
import infrastructure.utils.routing.permissions
import io.ktor.http.*
import io.ktor.http.HttpStatusCode.Companion.Forbidden
import io.ktor.http.HttpStatusCode.Companion.Unauthorized
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import kotlinx.coroutines.withContext

class AuthorizationConfig {
    internal var permissions: Set<Permission> = setOf()
    fun require(vararg permissions: Permission) {
        this@AuthorizationConfig.permissions = permissions.toSet()
    }
}

val AuthorizationPlugin = createRouteScopedPlugin(
    name = "AuthorizationPlugin",
    createConfiguration = ::AuthorizationConfig
) {
    onCall { call ->
        call.request.header(HttpHeaders.Authorization)?.let { authHeader ->
            JWTParser().parseHeader(authHeader)?.let { header ->
                header
            }
        }
//        validate(call)
        println("onCall")

    }
}

private suspend fun OnCallReceiveContext<AuthorizationConfig>.validate(call: PipelineCall) {
    val user = call.currentUser()
    if (user == null) {
        call.respond(Unauthorized)
        return
    }
    val userPermissions = user.permissions

    if (!pluginConfig.permissions.all { it in userPermissions }) {
        call.respond(
            Forbidden,
            "Forbidden for ${call.request.httpMethod.value}"
        )
    }
}

fun PipelineCall.currentUser(): UserDetails? {
    val jWTPrincipal = principal<JWTPrincipal>()
    val principal = jWTPrincipal ?: return null
    return UserDetails(
        name = principal.payload.getClaim("username").asString(),
        roles = principal.payload
            .getClaim("roles")
            .asList(String::class.java)
            .map { Role.valueOf(it) }
            .toSet(),
        permissions = principal.payload.permissions()
    )
}
