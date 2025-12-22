package infrastructure.utils.routing

import io.ktor.http.*
import io.ktor.http.ContentDisposition.Companion.Attachment
import io.ktor.http.ContentDisposition.Parameters.FileName
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


fun RoutingCall.i18nResource() = attributes[AttributeKey<ResourceBundle>("I18NLocale")]

val Parameters.id: UUID
    get() = this["id"]
        ?.let { UUID.fromString(it) }
        ?: error("No id parameter!")
