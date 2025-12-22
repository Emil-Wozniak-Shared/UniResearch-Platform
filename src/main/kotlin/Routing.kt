import common.Pageable
import common.SortDirection
import infrastructure.agency.adapter.`in`.http.AgencyHttpHandler
import infrastructure.agency.adapter.`in`.http.agencyRoutes
import infrastructure.exception.InvalidCredentials
import infrastructure.exception.NoPrincipalException
import infrastructure.institution.adapter.http.InstitutionHttpHandler
import infrastructure.institution.adapter.http.institutionRoutes
import infrastructure.permission.adapter.`in`.http.PermissionHttpHandler
import infrastructure.role.adapter.`in`.http.roleRoutes
import infrastructure.university.adapter.`in`.http.UniversityHttpHandler
import infrastructure.university.adapter.`in`.http.universityRoutes
import infrastructure.user.adapter.`in`.http.userRoutes
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
    routing {
        openAPI(path = "openapi")
        authenticate(AUTH_NAME, strategy = Required) {
            route("/api") {
                userRoutes()
                roleRoutes()
                agencyRoutes()
                institutionRoutes()
                universityRoutes()
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
