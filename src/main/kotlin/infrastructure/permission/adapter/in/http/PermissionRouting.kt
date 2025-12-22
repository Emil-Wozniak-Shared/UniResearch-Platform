package infrastructure.permission.adapter.`in`.http

import io.ktor.http.HttpStatusCode.Companion.Created
import io.ktor.server.application.Application
import io.ktor.server.response.respond
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.put
import io.ktor.server.routing.route
import io.ktor.server.routing.routing
import org.koin.ktor.ext.inject
import kotlin.getValue

fun Application.permissionRouting() {
    val permissionHandler: PermissionHttpHandler by inject()
    routing {
        route("/permissions") {
            get { call.respond(permissionHandler.list(call)) }
            get("/{id}") { call.respond(permissionHandler.find(call)) }
            post { call.respond(Created, permissionHandler.create(call)) }
            put("/{id}") { call.respond(permissionHandler.update(call)) }
            delete("/{id}") { call.respond(permissionHandler.delete(call)) }
        }
    }
}