package infrastructure.institution.adapter.http

import io.ktor.http.HttpStatusCode.Companion.Created
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.institutionRoutes() {
    val institutionHttpHandler: InstitutionHttpHandler by inject()
    route("/institutions") {
        get("/{id}") { call.respond(institutionHttpHandler.find(call)) }
        get { call.respond(institutionHttpHandler.list(call)) }
        post { call.respond(Created, institutionHttpHandler.create(call)) }
        put("/{id}") { call.respond(institutionHttpHandler.update(call)) }
        delete("/{id}") { call.respond(institutionHttpHandler.delete(call)) }
    }
}