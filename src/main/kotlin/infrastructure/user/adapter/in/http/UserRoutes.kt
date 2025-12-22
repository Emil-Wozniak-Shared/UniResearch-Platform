package infrastructure.user.adapter.`in`.http

import io.ktor.http.HttpStatusCode.Companion.Created
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.userRoutes() {
    val userHttpHandler: UserHttpHandler by inject()
    val userRoleHandler: UserRoleHttpHandler by inject()
    route("/users") {
        route("{userId}/roles") {
            get { call.respond(userRoleHandler.list(call)) }
            get("/{roleId}") { call.respond(userRoleHandler.find(call)) }
            post { call.respond(Created, userRoleHandler.create(call)) }
            put("/{roleId}") { call.respond(userRoleHandler.update(call)) }
            delete("/{roleId}") { call.respond(userRoleHandler.delete(call)) }
        }
        get("/{id}") { call.respond(userHttpHandler.find(call)) }
        get { call.respond(userHttpHandler.list(call)) }
        post { call.respond(Created, userHttpHandler.create(call)) }
        put("/{id}") { call.respond(userHttpHandler.update(call)) }
        delete("/{id}") { call.respond(userHttpHandler.delete(call)) }
    }
}