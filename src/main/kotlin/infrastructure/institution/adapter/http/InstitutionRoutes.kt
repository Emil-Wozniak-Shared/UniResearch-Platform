package infrastructure.institution.adapter.http

import AUTH_NAME
import configuration.AuthorizationPlugin
import domain.permission.Permission
import infrastructure.utils.routing.id
import io.ktor.http.HttpStatusCode.Companion.Created
import io.ktor.server.application.ApplicationCall
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import org.koin.ktor.ext.inject
import java.util.UUID

fun Route.institutionRoutes() {
    val institutionRoutes = InstitutionRoutes()
    val institutionHttpHandler: InstitutionHttpHandler by inject()
    route("/institutions") {
        get("/{id}") { call.respond(institutionHttpHandler.find(call)) }
        get { call.respond(institutionHttpHandler.list(call)) }
        secured(*Permission.allNotPublic) {
            post { call.respond(Created, institutionHttpHandler.create(call)) }
            put("/{id}") { call.respond(institutionHttpHandler.update(call)) }
            delete("/{id}") {
                println("enter ")
                call.respond(institutionRoutes.doStuff(call))
                println("after")
//                call.respond(institutionHttpHandler.delete(call))
            }
        }
    }
}

class InstitutionRoutes  {
    suspend fun doStuff(call: ApplicationCall) {
        val stuff = giveStuff(call.parameters.id)
        println("responding $stuff")
       call.respond(stuff)
    }

    fun giveStuff(id: UUID): Stuff {
        println("giveStuff")
        return Stuff(id.toString())
    }
}

@Serializable
data class Stuff(val id: String)

fun Route.secured(
    vararg permissions: Permission,
    build: Route.() -> Unit
): Route = route("") {
    authenticate(AUTH_NAME) {    // wrap in authentication
        install(AuthorizationPlugin) {
            require(*permissions)
        }
        build()
    }
}


