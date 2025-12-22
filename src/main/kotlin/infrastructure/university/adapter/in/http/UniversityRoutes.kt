package infrastructure.university.adapter.`in`.http

import io.ktor.http.HttpStatusCode.Companion.Created
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.universityRoutes() {
    val universityHttpHandler: UniversityHttpHandler by inject()

    route("/universities") {
        get("/{id}") { call.respond(universityHttpHandler.find(call)) }
        get { call.respond(universityHttpHandler.list(call)) }
        post { call.respond(Created, universityHttpHandler.create(call)) }
        put("/{id}") { call.respond(universityHttpHandler.update(call)) }
        delete("/{id}") { call.respond(universityHttpHandler.delete(call)) }
    }

}