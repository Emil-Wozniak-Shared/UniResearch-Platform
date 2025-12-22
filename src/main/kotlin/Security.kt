import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm.HMAC256
import infrastructure.auth.model.command.LoginCommand
import infrastructure.auth.model.command.MeCommand
import infrastructure.auth.model.request.LoginRequest
import infrastructure.auth.model.response.LoginResponse
import infrastructure.auth.port.`in`.http.AuthHttpPort
import infrastructure.exception.NoPrincipalException
import io.ktor.http.HttpStatusCode
import io.ktor.http.HttpStatusCode.Companion.Unauthorized
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

const val AUTH_NAME = "auth-jwt"

fun Application.configureSecurity() {
    val secret = environment.config.property("jwt.secret").getString()
    val issuer = environment.config.property("jwt.issuer").getString()
    val audience = environment.config.property("jwt.audience").getString()
    val realm = environment.config.property("jwt.realm").getString()

    val authHttpPort: AuthHttpPort by inject()
    authentication {
        jwt(AUTH_NAME) {
            this.realm = realm
            verifier(
                JWT
                    .require(HMAC256(secret))
                    .withAudience(audience)
                    .withIssuer(issuer)
                    .build()
            )
            validate { credential ->
                if (credential.payload.audience.contains(audience)) {
                    JWTPrincipal(credential.payload)
                } else {
                    null
                }
            }
            challenge { _, _ ->
                this@configureSecurity.log.error("JWT auth failed")
                call.respond(Unauthorized, "Invalid or expired token")
            }
        }
    }
    routing {
        post("/api/login") {
            call.receive<LoginRequest>()
                .let { (username, password) -> LoginCommand(username, password) }
                .let {  authHttpPort.login(it) }
                .run { call.respond(LoginResponse(token)) }
        }
        authenticate(AUTH_NAME) {
            get("/api/me") {
                val principal = call.principal<JWTPrincipal>() ?: throw NoPrincipalException()
                MeCommand(principal)
                    .let { authHttpPort.me(it) }
                    .let { call.respond(HttpStatusCode.OK, it) }
            }
        }
    }
}
