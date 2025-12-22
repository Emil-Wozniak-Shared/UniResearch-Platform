package infrastructure.agency.adapter.`in`.http

import io.ktor.http.HttpStatusCode.Companion.Created
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.agencyRoutes() {
    val agencyHttpHandler: AgencyHttpHandler by inject()
    route("/agencies") {
        get("/{id}") { call.respond(agencyHttpHandler.find(call)) }
        get { call.respond(agencyHttpHandler.list(call)) }
        post { call.respond(Created, agencyHttpHandler.create(call)) }
        put("/{id}") { call.respond(agencyHttpHandler.update(call)) }
        delete("/{id}") { call.respond(agencyHttpHandler.delete(call)) }
    }
}