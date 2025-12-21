package pl.ejdev

import io.ktor.http.HttpStatusCode.Companion.InternalServerError
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.plugins.openapi.*
import io.ktor.server.plugins.requestvalidation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.netty.handler.codec.DefaultHeaders
import kotlinx.serialization.json.Json

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
        openAPI(path = "openapi")
        route("/api") {
            route("/locations") {
                get {
                    call.respondText("List all locations")
                }
                get("/{id}") {
                    val id = call.parameters["id"]; call.respondText("Missing id")
                    call.respondText("Get location with id $id")
                }
                post {
                    call.respondText("Create location")
                }
                put("/{id}") {
                    val id = call.parameters["id"]; call.respondText("Missing id")
                    call.respondText("Update location $id")
                }
                delete("/{id}") {
                    val id = call.parameters["id"]; call.respondText("Missing id")
                    call.respondText("Delete location $id")
                }
            }
            route("/scientific/fields") {
                get { call.respondText("List all scientific fields") }
                get("/{id}") {
                    val id = call.parameters["id"]
                    call.respondText("Missing id"); call.respondText("Get scientific field $id")
                }
                post { call.respondText("Create scientific field") }
                put("/{id}") {
                    val id = call.parameters["id"]
                    call.respondText("Missing id"); call.respondText("Update scientific field $id")
                }
                delete("/{id}") {
                    val id = call.parameters["id"]
                    call.respondText("Missing id"); call.respondText("Delete scientific field $id")
                }
            }
            route("/agencies") {
                get { call.respondText("List all agencies") }
                get("/{id}") {
                    val id = call.parameters["id"]
                    call.respondText("Missing id"); call.respondText("Get agency $id")
                }
                post { call.respondText("Create agency") }
                put("/{id}") {
                    val id = call.parameters["id"]
                    call.respondText("Missing id"); call.respondText("Update agency $id")
                }
                delete("/{id}") {
                    val id = call.parameters["id"]
                    call.respondText("Missing id"); call.respondText("Delete agency $id")
                }
            }
            route("/universities") {
                get { call.respondText("List all universities") }
                get("/{id}") {
                    val id = call.parameters["id"]
                    call.respondText("Missing id"); call.respondText("Get university $id")
                }
                post { call.respondText("Create university") }
                put("/{id}") {
                    val id = call.parameters["id"]
                    call.respondText("Missing id"); call.respondText("Update university $id")
                }
                delete("/{id}") {
                    val id = call.parameters["id"]
                    call.respondText("Missing id"); call.respondText("Delete university $id")
                }
            }
            route("/institutes") {
                get { call.respondText("List all institutes") }
                get("/{id}") {
                    val id = call.parameters["id"]
                    call.respondText("Missing id"); call.respondText("Get institute $id")
                }
                post { call.respondText("Create institute") }
                put("/{id}") {
                    val id = call.parameters["id"]
                    call.respondText("Missing id"); call.respondText("Update institute $id")
                }
                delete("/{id}") {
                    val id = call.parameters["id"]
                    call.respondText("Missing id"); call.respondText("Delete institute $id")
                }
            }
            route("/researchers") {
                route("/programs") {
                    get { call.respondText("List all research programs") }
                    get("/{id}") {
                        val id = call.parameters["id"]
                        call.respondText("Missing id"); call.respondText("Get research program $id")
                    }
                    post { call.respondText("Create research program") }
                    put("/{id}") {
                        val id = call.parameters["id"]
                        call.respondText("Missing id"); call.respondText("Update research program $id")
                    }
                    delete("/{id}") {
                        val id = call.parameters["id"]
                        call.respondText("Missing id"); call.respondText("Delete research program $id")
                    }
                }
                route("/exchanges") {
                    get { call.respondText("List all researcher exchanges") }
                    get("/{id}") {
                        val id = call.parameters["id"]
                        call.respondText("Missing id"); call.respondText("Get researcher exchange $id")
                    }
                    post { call.respondText("Create researcher exchange") }
                    put("/{id}") {
                        call.parameters["id"]; call.respondText("Update researcher exchange ${call.parameters["id"]}")
                    }
                    delete("/{id}") {
                        call.parameters["id"]; call.respondText("Delete researcher exchange ${call.parameters["id"]}")
                    }
                }
                get { call.respondText("List all researchers") }
                get("/{id}") {
                    val id = call.parameters["id"]
                    call.respondText("Missing id"); call.respondText("Get researcher $id")
                }
                post { call.respondText("Create researcher") }
                put("/{id}") {
                    val id = call.parameters["id"]
                    call.respondText("Missing id"); call.respondText("Update researcher $id")
                }
                delete("/{id}") {
                    val id = call.parameters["id"]; call.respondText("Delete researcher $id")
                }
            }
            route("/buildings") {
                get { call.respondText("List all buildings") }
                get("/{id}") {
                    val id = call.parameters["id"]
                    call.respondText("Missing id"); call.respondText("Get building $id")
                }
                post { call.respondText("Create building") }
                put("/{id}") { call.parameters["id"]; call.respondText("Update building ${call.parameters["id"]}") }
                delete("/{id}") { call.parameters["id"]; call.respondText("Delete building ${call.parameters["id"]}") }
            }
            route("/rooms") {
                get { call.respondText("List all rooms") }
                get("/{id}") {
                    val id =
                        call.parameters["id"]; call.respondText("Missing id"); call.respondText("Get room $id")
                }
                post { call.respondText("Create room") }
                put("/{id}") { call.parameters["id"]; call.respondText("Update room ${call.parameters["id"]}") }
                delete("/{id}") { call.parameters["id"]; call.respondText("Delete room ${call.parameters["id"]}") }
            }
            route("/equipment") {
                get { call.respondText("List all equipment") }
                get("/{id}") {
                    val id = call.parameters["id"]
                    call.respondText("Missing id"); call.respondText("Get equipment $id")
                }
                post { call.respondText("Create equipment") }
                put("/{id}") { call.parameters["id"]; call.respondText("Update equipment ${call.parameters["id"]}") }
                delete("/{id}") { call.parameters["id"]; call.respondText("Delete equipment ${call.parameters["id"]}") }
            }
            route("/reagents") {
                get { call.respondText("List all reagents") }
                get("/{id}") {
                    val id = call.parameters["id"]
                    call.respondText("Missing id"); call.respondText("Get reagent $id")
                }
                post { call.respondText("Create reagent") }
                put("/{id}") { call.parameters["id"]; call.respondText("Update reagent ${call.parameters["id"]}") }
                delete("/{id}") { call.parameters["id"]; call.respondText("Delete reagent ${call.parameters["id"]}") }
            }
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
                        call.parameters["id"]; call.respondText("Missing id"); call.respondText("Get user $id")
                }
                post { call.respondText("Create user") }
                put("/{id}") { call.parameters["id"]; call.respondText("Update user ${call.parameters["id"]}") }
                delete("/{id}") { call.parameters["id"]; call.respondText("Delete user ${call.parameters["id"]}") }
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
                        call.parameters["id"]; call.respondText("Missing id"); call.respondText("Get role $id")
                }
                post { call.respondText("Create role") }
                put("/{id}") { call.parameters["id"]; call.respondText("Update role ${call.parameters["id"]}") }
                delete("/{id}") { call.parameters["id"]; call.respondText("Delete role ${call.parameters["id"]}") }
            }
            route("/permissions") {
                get { call.respondText("List all permissions") }
                get("/{id}") {
                    val id = call.parameters["id"]
                    call.respondText("Missing id"); call.respondText("Get permission $id")
                }
                post { call.respondText("Create permission") }
                put("/{id}") { call.parameters["id"]; call.respondText("Update permission ${call.parameters["id"]}") }
                delete("/{id}") {
                    call.parameters["id"]; call.respondText("Delete permission ${call.parameters["id"]}")
                }
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
                    val id = call.parameters["id"]
                    call.respondText("Missing id"); call.respondText("Get publication $id")
                }
                post { call.respondText("Create publication") }
                put("/{id}") { call.parameters["id"]; call.respondText("Update publication ${call.parameters["id"]}") }
                delete("/{id}") {
                    call.parameters["id"]; call.respondText("Delete publication ${call.parameters["id"]}")
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
                    val id = call.parameters["id"]
                    call.respondText("Missing id"); call.respondText("Get grant $id")
                }
                post { call.respondText("Create grant") }
                put("/{id}") { call.parameters["id"]; call.respondText("Update grant ${call.parameters["id"]}") }
                delete("/{id}") { call.parameters["id"]; call.respondText("Delete grant ${call.parameters["id"]}") }
            }
        }
    }
}
