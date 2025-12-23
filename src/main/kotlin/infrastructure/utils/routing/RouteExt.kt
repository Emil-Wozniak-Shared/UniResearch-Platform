package infrastructure.utils.routing

import com.auth0.jwt.interfaces.Payload
import domain.role.Role
import domain.user.UserDetails
import io.ktor.http.*
import io.ktor.http.ContentDisposition.Companion.Attachment
import io.ktor.http.ContentDisposition.Parameters.FileName
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.*
import io.ktor.util.pipeline.*
import java.util.*

suspend inline fun RoutingCall.respondPdf(bytes: ByteArray, fileName: String) {
    response.headers.append(
        HttpHeaders.ContentDisposition, Attachment.withParameter(FileName, "$fileName.pdf")
            .toString()
    )
    respondOutputStream(contentType = ContentType.Application.Pdf) { this.write(bytes) }
}


fun RoutingCall.i18nResource() = attributes[AttributeKey<ResourceBundle>("I18NLocale")]

fun PipelineContext<Unit, ApplicationCall>.currentUser(): UserDetails? {
    val principal = call.principal<JWTPrincipal>() ?: return null
    val id = principal.payload.getClaim("id").asString()
    val name = principal.payload.username()
    val roles = principal.payload.roles()
    return UserDetails(id, name, roles)
}

fun Payload.roles() = getClaim("roles").asList(String::class.java).map { Role.valueOf(it) }.toSet()
fun Payload.username(): String = getClaim("username").asString()

val Parameters.id: UUID
    get() = this["id"]
        ?.let { UUID.fromString(it) }
        ?: error("No id parameter!")
