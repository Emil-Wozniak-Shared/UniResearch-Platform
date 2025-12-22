package infrastructure.auth.adapter.`in`.http

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm.HMAC256
import common.Filter
import common.FilterOp
import common.Pageable
import infrastructure.auth.model.command.LoginCommand
import infrastructure.auth.model.result.LoginResult
import infrastructure.auth.port.`in`.http.AuthHttpPort
import infrastructure.exception.InvalidCredentials
import infrastructure.user.adapter.out.persistence.Users
import infrastructure.user.model.event.ListUserEvent
import infrastructure.user.port.out.persistence.UserPersistencePort
import io.ktor.server.config.*
import java.util.Date

class AuthHttpAdapter(
    private val userPersistence: UserPersistencePort,
    private val config: ApplicationConfig
) : AuthHttpPort {
    private val secret = config.property("jwt.secret").getString()
    private val issuer = config.property("jwt.issuer").getString()
    private val audience = config.property("jwt.audience").getString()

    override suspend fun login(command: LoginCommand): LoginResult {
        val filters = listOf(
            Filter(Users.username.name, FilterOp.EQ, command.username)
        )
        val event = ListUserEvent(Pageable(0, 1, filters = filters))
        val user = userPersistence
            .list(event)
            .entities
            .firstOrNull()
            ?: throw InvalidCredentials()

        // ⚠️ Replace with real password hashing (BCrypt recommended)
        if (user.passwordHash != command.password) {
            throw InvalidCredentials()
        }

        val token = JWT.create()
            .withAudience(audience)
            .withIssuer(issuer)
            .withClaim("username", user.username)
            .withExpiresAt(Date(System.currentTimeMillis() + 60000))
            .sign(HMAC256(secret))

        return LoginResult(token)
    }

}
