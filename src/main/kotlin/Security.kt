import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm.HMAC256
import infrastructure.auth.model.request.LoginRequest
import infrastructure.auth.model.response.LoginResponse
import io.ktor.http.HttpStatusCode
import io.ktor.http.HttpStatusCode.Companion.Unauthorized
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.AuthenticationStrategy.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*

const val AUTH_NAME = "auth-jwt"

fun Application.configureSecurity() {
    val secret = environment.config.property("jwt.secret").getString()
    val issuer = environment.config.property("jwt.issuer").getString()
    val audience = environment.config.property("jwt.audience").getString()
    val realm = environment.config.property("jwt.realm").getString()
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
                call.respond(Unauthorized, "Token is invalid or expired")
            }
        }
    }
    routing {
        post("/api/login") {
            val user = call.receive<LoginRequest>()
            val token = JWT.create()
                .withAudience(audience)
                .withIssuer(issuer)
                .withClaim("username", user.username)
                .withExpiresAt(Date(System.currentTimeMillis() + 60000))
                .sign(HMAC256(secret))
            call.respond(LoginResponse(token))
        }
        authenticate(AUTH_NAME, strategy = Required) {
            get("/hello") {
                val principal = call.principal<JWTPrincipal>() ?: error("No JWT principal")
                val username = principal.payload.getClaim("username").asString()
                val expiresAt = principal.expiresAt?.time?.minus(System.currentTimeMillis())
                call.respondText("Hello, $username! Token is expired at $expiresAt ms.")
            }
        }
    }
}
