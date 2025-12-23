package infrastructure.utils.routing

import AUTH_NAME
import com.auth0.jwt.interfaces.Payload
import configuration.AuthorizationPlugin
import domain.permission.Permission
import domain.role.Role
import io.ktor.http.*
import io.ktor.http.ContentDisposition.Companion.Attachment
import io.ktor.http.ContentDisposition.Parameters.FileName
import io.ktor.http.HttpHeaders.ContentDisposition
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.*
import java.util.*

private const val ID = "id"
private const val USERNAME = "username"
private const val ROLES = "roles"
private const val PERMISSIONS = "permissions"

suspend inline fun RoutingCall.respondPdf(bytes: ByteArray, fileName: String) {
    response.headers.append(
        ContentDisposition, Attachment.withParameter(FileName, "$fileName.pdf")
            .toString()
    )
    respondOutputStream(contentType = ContentType.Application.Pdf) { this.write(bytes) }
}

fun Payload.roles() = getClaim(ROLES).asList(String::class.java)
    .map { Role.valueOf(it) }
    .toSet()


fun Payload.permissions() = getClaim(PERMISSIONS).asList(String::class.java)
    .map(Permission::valueOf)
    .toSet()

fun Payload.username(): String = getClaim(USERNAME).asString()

fun Route.secure(vararg permissions: Permission, build: Route.() -> Unit): Route = route("") {
    authenticate(AUTH_NAME) {
        install(AuthorizationPlugin) {
            require(*permissions)
        }
        build()
    }
}

fun RoutingCall.i18nResource() = attributes[AttributeKey<ResourceBundle>("I18NLocale")]

val Parameters.id: UUID
    get() = this[ID]
        ?.let { UUID.fromString(it) }
        ?: error("No id parameter!")
