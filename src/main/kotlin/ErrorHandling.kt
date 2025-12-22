import infrastructure.exception.InvalidCredentials
import infrastructure.exception.NoPrincipalException
import io.ktor.http.HttpStatusCode
import io.ktor.http.HttpStatusCode.Companion.BadRequest
import io.ktor.http.HttpStatusCode.Companion.InternalServerError
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.request.uri
import io.ktor.server.response.respond
import kotlinx.serialization.Serializable

@Serializable
data class ProblemDetail(
    val type: String = "",
    val title: String,
    val status: Int,
    val detail: String? = null,
    val instance: String? = null
)

fun Application.configureErrorHandling() {
    install(StatusPages) {
        exception<InvalidCredentials> { call, cause ->
            call.respond(
                BadRequest,
                ProblemDetail(
                    title = "Invalid credentials",
                    status = BadRequest.value,
                    detail = cause.message,
                    instance = call.request.uri
                )
            )
        }
        exception<NoPrincipalException> { call, cause ->
            call.respond(
                BadRequest,
                ProblemDetail(
                    title = NoPrincipalException::class.java.simpleName,
                    status = BadRequest.value,
                    detail = cause.message,
                    instance = call.request.uri
                )
            )
        }
        exception<Throwable> { call, cause ->
            call.respond(
                InternalServerError,
                ProblemDetail(
                    title = "Internal Server Error",
                    status = InternalServerError.value,
                    detail = cause.message ?: "Unexpected error",
                    instance = call.request.uri
                )
            )
        }
    }
}