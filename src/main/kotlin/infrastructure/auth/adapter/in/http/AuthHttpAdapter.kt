package infrastructure.auth.adapter.`in`.http

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm.HMAC256
import infrastructure.auth.model.command.LoginCommand
import infrastructure.auth.model.command.MeCommand
import infrastructure.auth.model.event.FindWithRolesAndPermissionsEvent
import infrastructure.auth.model.response.MeResponse
import infrastructure.auth.model.response.MyPermission
import infrastructure.auth.model.response.MyRole
import infrastructure.auth.model.result.FindWithRolesAndPermissionsResult
import infrastructure.auth.model.result.LoginResult
import infrastructure.auth.port.`in`.http.AuthHttpPort
import infrastructure.auth.port.out.persistence.UserDetailsRepositoryPort
import infrastructure.utils.routing.username
import io.ktor.server.config.*
import java.nio.file.attribute.UserPrincipalNotFoundException
import java.util.*

class AuthHttpAdapter(
    private val userDetailsRepositoryPort: UserDetailsRepositoryPort,
    private val config: ApplicationConfig,
) : AuthHttpPort {
    private val secret = config.property("jwt.secret").getString()
    private val issuer = config.property("jwt.issuer").getString()
    private val audience = config.property("jwt.audience").getString()

    override suspend fun login(command: LoginCommand): LoginResult =
        FindWithRolesAndPermissionsEvent(command.username)
            .let { userDetailsRepositoryPort.findWithRolesAndPermissions(it) }
            .let {
                when (it) {
                    is FindWithRolesAndPermissionsResult.None -> throw UserPrincipalNotFoundException("User does not exist")
                    is FindWithRolesAndPermissionsResult.Some -> validatePassword()
                        .run { LoginResult(token = generateToken(it)) }
                }
            }

    override suspend fun me(command: MeCommand): MeResponse =
        command.principal.payload.username()
            .let(::FindWithRolesAndPermissionsEvent)
            .let { userDetailsRepositoryPort.findWithRolesAndPermissions(it) }
            .let { result ->
                when (result) {
                    is FindWithRolesAndPermissionsResult.None -> throw UserPrincipalNotFoundException("User does not exist")
                    is FindWithRolesAndPermissionsResult.Some -> MeResponse(
                        username = result.user.username,
                        roles = result.roles.map { MyRole(it.name, it.description) }.toSet(),
                        permissions = result.permissions.map { MyPermission(it.name, it.description) }.toSet(),
                    )
                }
            }

    private fun validatePassword() {
        // ⚠️ Replace with real password hashing (BCrypt recommended)
//                if (user.passwordHash != command.password) {
//                    throw InvalidCredentials()
//                }
    }

    private fun generateToken(result: FindWithRolesAndPermissionsResult.Some): String =
        JWT.create()
            .withIssuer(issuer)
            .withAudience(audience)
            .withClaim("username", result.user.username)
            .withArrayClaim("roles", result.roles.map { it.name }.toTypedArray())
            .withExpiresAt(Date(System.currentTimeMillis() + 15 * 60 * 1000))
            .sign(HMAC256(secret))

}
