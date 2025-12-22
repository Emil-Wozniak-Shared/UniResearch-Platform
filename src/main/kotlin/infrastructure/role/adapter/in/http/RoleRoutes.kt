package infrastructure.role.adapter.`in`.http

import infrastructure.permission.adapter.`in`.http.RolePermissionHttpHandler
import io.ktor.http.HttpStatusCode.Companion.Created
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.roleRoutes() {
    val roleHttpHandler: RoleHttpHandler by inject()
    val rolePermissionHandler: RolePermissionHttpHandler by inject()
    route("/roles") {
        route("/{roleId}/permissions") {
            get { call.respond(rolePermissionHandler.list(call)) }
            get("/{permissionId}") { call.respond(rolePermissionHandler.find(call)) }
            post { call.respond(Created, rolePermissionHandler.create(call)) }
            put("/{permissionId}") { call.respond(rolePermissionHandler.update(call)) }
            delete("/{permissionId}") { call.respond(rolePermissionHandler.delete(call)) }
        }
        get("/{id}") { call.respond(roleHttpHandler.find(call)) }
        get { call.respond(roleHttpHandler.list(call)) }
        post { call.respond(Created, roleHttpHandler.create(call)) }
        put("/{id}") { call.respond(roleHttpHandler.update(call)) }
        delete("/{id}") { call.respond(roleHttpHandler.delete(call)) }
    }
}