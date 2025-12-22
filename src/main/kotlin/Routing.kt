import common.Pageable
import common.SortDirection
import infrastructure.agency.adapter.`in`.http.AgencyHttpHandler
import infrastructure.exception.InvalidCredentials
import infrastructure.institution.adapter.http.InstitutionHttpHandler
import infrastructure.permission.adapter.`in`.http.PermissionHttpHandler
import infrastructure.permission.adapter.`in`.http.RolePermissionHttpHandler
import infrastructure.role.adapter.`in`.http.RoleHttpHandler
import infrastructure.university.adapter.`in`.http.UniversityHttpHandler
import infrastructure.user.adapter.`in`.http.UserHttpHandler
import infrastructure.user.adapter.`in`.http.UserRoleHttpHandler
import infrastructure.utils.routing.id
import io.ktor.http.HttpStatusCode
import io.ktor.http.HttpStatusCode.Companion.Created
import io.ktor.http.HttpStatusCode.Companion.InternalServerError
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.AuthenticationStrategy.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.openapi.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.uri
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import org.koin.ktor.ext.inject

@Serializable
data class ProblemDetail(
    val type: String = "",
    val title: String,
    val status: Int,
    val detail: String? = null,
    val instance: String? = null
)

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
        exception<InvalidCredentials> { call, cause ->
            call.respond(
                HttpStatusCode.BadRequest,
                ProblemDetail(
                    title = "Invalid credentials",
                    status = HttpStatusCode.BadRequest.value,
                    detail = cause.message,
                    instance = call.request.uri
                )
            )
        }
        exception<Throwable> { call, cause ->
            call.respond(
                InternalServerError,
                ProblemDetail(
                    title = "Internal Server Error",
                    status = InternalServerError.value,
                    detail = cause.message ?: "Unexpected error",
                    instance = call.request.uri
                )
            )
        }
    }
    routing {
        val agencyHttpHandler: AgencyHttpHandler by inject()
        val universityHttpHandler: UniversityHttpHandler by inject()
        val institutionHttpHandler: InstitutionHttpHandler by inject()
        val userHttpHandler: UserHttpHandler by inject()
        val roleHttpHandler: RoleHttpHandler by inject()
        val userRoleHandler: UserRoleHttpHandler by inject()
        val permissionHandler: PermissionHttpHandler by inject()
        val rolePermissionHandler: RolePermissionHttpHandler by inject()

        openAPI(path = "openapi")
        authenticate(AUTH_NAME, strategy = Required) {
            route("/api") {
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
                route("/permissions") {
                    get { call.respond(permissionHandler.list(call)) }
                    get("/{id}") { call.respond(permissionHandler.find(call)) }
                    post { call.respond(Created, permissionHandler.create(call)) }
                    put("/{id}") { call.respond(permissionHandler.update(call)) }
                    delete("/{id}") { call.respond(permissionHandler.delete(call)) }
                }
                route("/agencies") {
                    get("/{id}") { call.respond(agencyHttpHandler.find(call)) }
                    get { call.respond(agencyHttpHandler.list(call)) }
                    post { call.respond(Created, agencyHttpHandler.create(call)) }
                    put("/{id}") { call.respond(agencyHttpHandler.update(call)) }
                    delete("/{id}") { call.respond(agencyHttpHandler.delete(call)) }
                }
                route("/institutions") {
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
                    get("/{id}") { call.respondText("Get building ${call.parameters.id}") }
                    post { call.respondText("Create building") }
                    put("/{id}") { call.respondText("Update building ${call.parameters.id}") }
                    delete("/{id}") { call.respondText("Delete building ${call.parameters.id}") }
                }
                route("/rooms") {
                    get { call.respondText("List all rooms") }
                    get("/{id}") {call.respondText("Get room ${call.parameters.id}") }
                    post { call.respondText("Create room") }
                    put("/{id}") { call.respondText("Update room ${call.parameters.id}") }
                    delete("/{id}") { call.respondText("Delete room ${call.parameters.id}") }
                }
                route("/equipment") {
                    get { call.respondText("List all equipment") }
                    get("/{id}") { call.respondText("Get equipment ${call.parameters.id}") }
                    post { call.respondText("Create equipment") }
                    put("/{id}") { call.respondText("Update equipment ${call.parameters.id}") }
                    delete("/{id}") { call.respondText("Delete equipment ${call.parameters.id}") }
                }
                route("/locations") {
                    get { call.respondText("List all locations") }
                    get("/{id}") { call.respondText("Get location with id ${call.parameters.id}") }
                    post { call.respondText("Create location") }
                    put("/{id}") { call.respondText("Update location ${call.parameters.id}") }
                    delete("/{id}") { call.respondText("Delete location ${call.parameters.id}") }
                }
                route("/scientific/fields") {
                    get { call.respondText("List all scientific fields") }
                    get("/{id}") { call.respondText("Get scientific field ${call.parameters.id}") }
                    post { call.respondText("Create scientific field") }
                    put("/{id}") { call.respondText("Update scientific field ${call.parameters.id}") }
                    delete("/{id}") { call.respondText("Delete scientific field ${call.parameters.id}") }
                }
                route("/researchers") {
                    route("/programs") {
                        get { call.respondText("List all research programs") }
                        get("/{id}") { call.respondText("Get research program ${call.parameters.id}") }
                        post { call.respondText("Create research program") }
                        put("/{id}") { call.respondText("Update research program ${call.parameters.id}") }
                        delete("/{id}") { call.respondText("Delete research program ${call.parameters.id}") }
                    }
                    route("/exchanges") {
                        get { call.respondText("List all researcher exchanges") }
                        get("/{id}") {call.respondText("Get researcher exchange ${call.parameters.id}") }
                        post { call.respondText("Create researcher exchange") }
                        put("/{id}") { call.respondText("Update researcher exchange ${call.parameters.id}")}
                        delete("/{id}") { call.respondText("Delete researcher exchange ${call.parameters.id}") }
                    }
                    get { call.respondText("List all researchers") }
                    get("/{id}") {call.respondText("Get researcher ${call.parameters.id}") }
                    post { call.respondText("Create researcher") }
                    put("/{id}") {call.respondText("Update researcher ${call.parameters.id}") }
                    delete("/{id}") { call.respondText("Delete researcher ${call.parameters.id}") }
                }
                route("/reagents") {
                    get { call.respondText("List all reagents") }
                    get("/{id}") {call.respondText("Get reagent ${call.parameters.id}") }
                    post { call.respondText("Create reagent") }
                    put("/{id}") { call.respondText("Update reagent ${call.parameters.id}") }
                    delete("/{id}") { call.respondText("Delete reagent ${call.parameters.id}") }
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
                    get("/{id}") {call.respondText("Get publication ${call.parameters.id}") }
                    post { call.respondText("Create publication") }
                    put("/{id}") { call.respondText("Update publication ${call.parameters.id}") }
                    delete("/{id}") { call.respondText("Delete publication ${call.parameters.id}") }
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
                    get("/{id}") {call.respondText("Get grant ${call.parameters.id}") }
                    post { call.respondText("Create grant") }
                    put("/{id}") { call.respondText("Update grant ${call.parameters.id}") }
                    delete("/{id}") { call.respondText("Delete grant ${call.parameters.id}") }
                }
            }
        }
    }
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
