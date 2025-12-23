package infrastructure.institution.adapter.http

import domain.permission.Permission
import infrastructure.utils.routing.respondPdf
import infrastructure.utils.routing.secure
import io.ktor.http.HttpStatusCode.Companion.Created
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.institutionRoutes() {
    val handler: InstitutionHttpHandler by inject()
    route("/institutions") {
        get("/{id}") { call.respond(handler.find(call)) }
        get { call.respond(handler.list(call)) }
        secure(*Permission.allNotPublic) {
            post { call.respond(Created, handler.create(call)) }
            put("/{id}") { call.respond(handler.update(call)) }
            delete("/{id}") { call.respond(handler.delete(call)) }
        }
        secure(Permission.GENERATE_REPORTS) {
            post("/report") {
                handler.report(call).let { (content, filename) -> call.respondPdf(content, filename) }
            }
        }
    }
}

