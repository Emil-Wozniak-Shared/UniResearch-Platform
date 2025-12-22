package pl.ejdev

import AUTH_NAME
import io.ktor.http.HttpStatusCode.Companion.Created
import io.ktor.http.HttpStatusCode.Companion.InternalServerError
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.openapi.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import org.koin.ktor.ext.inject
import common.Pageable
import common.SortDirection
import infrastructure.agency.adapter.`in`.http.AgencyHttpHandler
import infrastructure.institution.adapter.http.InstitutionHttpHandler
import infrastructure.university.adapter.`in`.http.UniversityHttpHandler
import io.ktor.server.auth.AuthenticationStrategy.Required
import io.ktor.server.auth.authenticate
import java.util.*

fun Application.configureRouting() {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
            ignoreUnknownKeys = true
        })
    }
    install(RequestValidation) {
        validate<String> { bodyText ->
            if (!bodyText.startsWith("Hello"))
                ValidationResult.Invalid("Body text should start with 'Hello'")
            else ValidationResult.Valid
        }
    }
    install(StatusPages) {
        exception<Throwable> { call, cause -> call.respondText(text = "500: $cause", status = InternalServerError) }
    }
    routing {
        val agencyHttpHandler: AgencyHttpHandler by inject()
        val universityHttpHandler: UniversityHttpHandler by inject()
        val institutionHttpHandler: InstitutionHttpHandler by inject()

        openAPI(path = "openapi")
        authenticate(AUTH_NAME, strategy = Required) {
            route("/api") {
                route("/users") {
                    route("/roles") {
                        get { call.respondText("List all user roles") }
                        get("/{userId}/{roleId}") { call.respondText("Get userRole") }
                        post { call.respondText("Create userRole") }
                        put("/{userId}/{roleId}") { call.respondText("Update userRole") }
                        delete("/{userId}/{roleId}") { call.respondText("Delete userRole") }
                    }
                    get { call.respondText("List all users") }
                    get("/{id}") {
                        val id =
                            call.respondText("Missing id"); call.respondText("Get user $id")
                    }
                    post { call.respondText("Create user") }
                    put("/{id}") { call.respondText("Update user ${call.id}") }
                    delete("/{id}") { call.respondText("Delete user ${call.id}") }
                }
                route("/roles") {
                    route("/permissions") {
                        get { call.respondText("List all role permissions") }
                        get("/{roleId}/{permissionId}") { call.respondText("Get rolePermission") }
                        post { call.respondText("Create rolePermission") }
                        put("/{roleId}/{permissionId}") { call.respondText("Update rolePermission") }
                        delete("/{roleId}/{permissionId}") { call.respondText("Delete rolePermission") }
                    }
                    get { call.respondText("List all roles") }
                    get("/{id}") {
                        val id =
                            call.respondText("Missing id"); call.respondText("Get role $id")
                    }
                    post { call.respondText("Create role") }
                    put("/{id}") { call.respondText("Update role ${call.id}") }
                    delete("/{id}") { call.respondText("Delete role ${call.id}") }
                }
                route("/permissions") {
                    get { call.respondText("List all permissions") }
                    get("/{id}") {
                        val id = call.id
                        call.respondText("Missing id"); call.respondText("Get permission $id")
                    }
                    post { call.respondText("Create permission") }
                    put("/{id}") { call.respondText("Update permission ${call.id}") }
                    delete("/{id}") {
                        call.respondText("Delete permission ${call.id}")
                    }
                }
                route("/agencies") {
                    get("/{id}") { call.respond(agencyHttpHandler.find(call)) }
                    get { call.respond(agencyHttpHandler.list(call)) }
                    post { call.respond(Created, agencyHttpHandler.create(call)) }
                    put("/{id}") { call.respond(agencyHttpHandler.update(call)) }
                    delete("/{id}") { call.respond(agencyHttpHandler.delete(call)) }
                }
                route("/institution") {
                    get("/{id}") { call.respond(institutionHttpHandler.find(call)) }
                    get { call.respond(institutionHttpHandler.list(call)) }
                    post { call.respond(Created, institutionHttpHandler.create(call)) }
                    put("/{id}") { call.respond(institutionHttpHandler.update(call)) }
                    delete("/{id}") { call.respond(institutionHttpHandler.delete(call)) }
                }
                route("/universities") {
                    get("/{id}") { call.respond(universityHttpHandler.find(call)) }
                    get { call.respond(universityHttpHandler.list(call)) }
                    post { call.respond(Created, universityHttpHandler.create(call)) }
                    put("/{id}") { call.respond(universityHttpHandler.update(call)) }
                    delete("/{id}") { call.respond(universityHttpHandler.delete(call)) }
                }
                route("/buildings") {
                    get { call.respondText("List all buildings") }
                    get("/{id}") {
                        val id = call.id
                        call.respondText("Missing id"); call.respondText("Get building $id")
                    }
                    post { call.respondText("Create building") }
                    put("/{id}") { call.respondText("Update building ${call.id}") }
                    delete("/{id}") { call.respondText("Delete building ${call.id}") }
                }
                route("/rooms") {
                    get { call.respondText("List all rooms") }
                    get("/{id}") {
                        val id =
                            call.respondText("Missing id"); call.respondText("Get room $id")
                    }
                    post { call.respondText("Create room") }
                    put("/{id}") { call.respondText("Update room ${call.id}") }
                    delete("/{id}") { call.respondText("Delete room ${call.id}") }
                }
                route("/equipment") {
                    get { call.respondText("List all equipment") }
                    get("/{id}") {
                        val id = call.id
                        call.respondText("Missing id"); call.respondText("Get equipment $id")
                    }
                    post { call.respondText("Create equipment") }
                    put("/{id}") { call.respondText("Update equipment ${call.id}") }
                    delete("/{id}") { call.respondText("Delete equipment ${call.id}") }
                }
                route("/locations") {
                    get { call.respondText("List all locations") }
                    get("/{id}") { call.respondText("Get location with id ${call.id}") }
                    post { call.respondText("Create location") }
                    put("/{id}") { call.respondText("Update location ${call.id}") }
                    delete("/{id}") { call.respondText("Delete location ${call.id}") }
                }
                route("/scientific/fields") {
                    get { call.respondText("List all scientific fields") }
                    get("/{id}") { call.respondText("Get scientific field ${call.id}") }
                    post { call.respondText("Create scientific field") }
                    put("/{id}") { call.respondText("Update scientific field ${call.id}") }
                    delete("/{id}") { call.respondText("Delete scientific field ${call.id}") }
                }
                route("/researchers") {
                    route("/programs") {
                        get { call.respondText("List all research programs") }
                        get("/{id}") {
                            val id = call.id
                            call.respondText("Missing id"); call.respondText("Get research program $id")
                        }
                        post { call.respondText("Create research program") }
                        put("/{id}") {
                            val id = call.id
                            call.respondText("Missing id"); call.respondText("Update research program $id")
                        }
                        delete("/{id}") {
                            val id = call.id
                            call.respondText("Missing id"); call.respondText("Delete research program $id")
                        }
                    }
                    route("/exchanges") {
                        get { call.respondText("List all researcher exchanges") }
                        get("/{id}") {
                            val id = call.id
                            call.respondText("Missing id"); call.respondText("Get researcher exchange $id")
                        }
                        post { call.respondText("Create researcher exchange") }
                        put("/{id}") {
                            call.respondText("Update researcher exchange ${call.id}")
                        }
                        delete("/{id}") {
                            call.respondText("Delete researcher exchange ${call.id}")
                        }
                    }
                    get { call.respondText("List all researchers") }
                    get("/{id}") {
                        val id = call.id
                        call.respondText("Missing id"); call.respondText("Get researcher $id")
                    }
                    post { call.respondText("Create researcher") }
                    put("/{id}") {
                        val id = call.id
                        call.respondText("Missing id"); call.respondText("Update researcher $id")
                    }
                    delete("/{id}") {
                        call.respondText("Delete researcher ${call.id}")
                    }
                }
                route("/reagents") {
                    get { call.respondText("List all reagents") }
                    get("/{id}") {
                        val id = call.id
                        call.respondText("Missing id"); call.respondText("Get reagent $id")
                    }
                    post { call.respondText("Create reagent") }
                    put("/{id}") { call.respondText("Update reagent ${call.id}") }
                    delete("/{id}") { call.respondText("Delete reagent ${call.id}") }
                }

                route("/publications") {
                    route("/authors") {
                        get { call.respondText("List all publication authors") }
                        get("/{publicationId}/{researcherId}") { call.respondText("Get publication author") }
                        post { call.respondText("Create publication author") }
                        put("/{publicationId}/{researcherId}") { call.respondText("Update publication author") }
                        delete("/{publicationId}/{researcherId}") { call.respondText("Delete publication author") }
                    }
                    get { call.respondText("List all publications") }
                    get("/{id}") {
                        val id = call.id
                        call.respondText("Missing id"); call.respondText("Get publication $id")
                    }
                    post { call.respondText("Create publication") }
                    put("/{id}") { call.respondText("Update publication ${call.id}") }
                    delete("/{id}") {
                        call.respondText("Delete publication ${call.id}")
                    }
                }
                route("/grants") {
                    route("/participants") {
                        get { call.respondText("List all grant participants") }
                        get("/{grantId}/{researcherId}") { call.respondText("Get grant participant") }
                        post { call.respondText("Create grant participant") }
                        put("/{grantId}/{researcherId}") { call.respondText("Update grant participant") }
                        delete("/{grantId}/{researcherId}") { call.respondText("Delete grant participant") }
                    }

                    route("/publications") {
                        get { call.respondText("List all grant publications") }
                        get("/{grantId}/{publicationId}") { call.respondText("Get grant publication") }
                        post { call.respondText("Create grant publication") }
                        put("/{grantId}/{publicationId}") { call.respondText("Update grant publication") }
                        delete("/{grantId}/{publicationId}") { call.respondText("Delete grant publication") }
                    }

                    get { call.respondText("List all grants") }
                    get("/{id}") {
                        val id = call.id
                        call.respondText("Missing id"); call.respondText("Get grant $id")
                    }
                    post { call.respondText("Create grant") }
                    put("/{id}") { call.respondText("Update grant ${call.id}") }
                    delete("/{id}") { call.respondText("Delete grant ${call.id}") }
                }
            }
        }
    }
}

val RoutingCall.id: UUID
    get() {
        val id = parameters["id"] ?: error("Missing id")
        return UUID.fromString(id)
    }

fun ApplicationCall.toPageable(): Pageable {
    val page = this.request.queryParameters["page"]?.toIntOrNull() ?: 0
    val size = this.request.queryParameters["size"]?.toIntOrNull() ?: 20
    val sortBy = this.request.queryParameters["sortBy"]
    val sortDir = when (this.request.queryParameters["sortDir"]?.uppercase()) {
        "DESC" -> SortDirection.DESC
        else -> SortDirection.ASC
    }

    return Pageable(page = page, size = size, sortBy = sortBy, sortDir = sortDir)
}
