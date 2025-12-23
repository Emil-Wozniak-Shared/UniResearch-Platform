package infrastructure.utils.routing

import AUTH_NAME
import com.auth0.jwt.interfaces.Payload
import configuration.AuthorizationPlugin
import domain.permission.Permission
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
import java.util.*

suspend inline fun RoutingCall.respondPdf(bytes: ByteArray, fileName: String) {
    response.headers.append(
        HttpHeaders.ContentDisposition, Attachment.withParameter(FileName, "$fileName.pdf")
            .toString()
    )
    respondOutputStream(contentType = ContentType.Application.Pdf) { this.write(bytes) }
}

fun Payload.roles() = getClaim("roles").asList(String::class.java)
    .map { Role.valueOf(it) }
    .toSet()

fun Payload.permissions() = getClaim("permissions").asList(String::class.java)
    .map { Permission.valueOf(it) }
    .toSet()

fun Payload.username(): String = getClaim("username").asString()

fun RoutingCall.i18nResource() = attributes[AttributeKey<ResourceBundle>("I18NLocale")]

val Parameters.id: UUID
    get() = this["id"]
        ?.let { UUID.fromString(it) }
        ?: error("No id parameter!")
