package configuration

import com.auth0.jwt.JWT
import domain.permission.Permission
import io.ktor.http.HttpHeaders.Authorization
import io.ktor.http.HttpStatusCode.Companion.Forbidden
import io.ktor.http.HttpStatusCode.Companion.Unauthorized
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*

private const val AUTHORIZATION_PLUGIN = "AuthorizationPlugin"

val AuthorizationPlugin = createRouteScopedPlugin(AUTHORIZATION_PLUGIN, ::AuthorizationConfig) {
    onCall { pluginConfig.authorizationOrElse(it) }
}

class AuthorizationConfig {
    private val jwt = JWT()

    private val permissions: MutableSet<Permission> = mutableSetOf()

    fun require(vararg permissions: Permission) {
        this.permissions.addAll(permissions)
    }

    private fun getPermissions(authHeader: String): Set<Permission> = jwt.decodeJwt(authHeader.substringAfter(BEARER))
        .getClaim(PERMISSIONS)
        .asList(String::class.java)
        .map { Permission.valueOf(it) }
        .toSet()

    private fun notValid(authHeader: String): Boolean {
        val userPermissions = getPermissions(authHeader)
        return permissions.any { it !in userPermissions }
    }

    suspend fun authorizationOrElse(
        call: PipelineCall,
    ) {
        val header = call.request.header(Authorization)
        if (header == null) {
            call.respond(Unauthorized)
        }
        requireNotNull(header).takeIf(this::notValid)?.let { _ ->
            call.respond(Forbidden)
        }
    }

    private companion object {
        const val BEARER = "Bearer "
        const val PERMISSIONS = "permissions"
    }
}
