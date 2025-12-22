package infrastructure.university.adapter.`in`.http

import infrastructure.university.model.command.CreateUniversityCommand
import infrastructure.university.model.command.FindUniversityCommand
import infrastructure.university.model.event.*
import infrastructure.university.model.result.*
import infrastructure.university.port.`in`.http.UniversityHttpPort
import infrastructure.utils.routing.id
import io.ktor.server.request.*
import io.ktor.server.routing.*
import pl.ejdev.toPageable

class UniversityHttpHandler(
    private val universityHttpPort: UniversityHttpPort
) {
    suspend fun find(call: RoutingCall): FindUniversityResult =
        FindUniversityCommand(call.parameters.id)
            .run { FindUniversityEvent(id) }
            .let { universityHttpPort.find(it) }

    suspend fun list(call: RoutingCall): ListUniversityResult =
        ListUniversityEvent(call.toPageable())
            .let { universityHttpPort.list(it) }

    suspend fun create(call: RoutingCall): CreateUniversityResult =
        call.receive<CreateUniversityCommand>()
            .run { CreateUniversityEvent(entity) }
            .let { universityHttpPort.create(it) }

    suspend fun update(call: RoutingCall): UpdateUniversityResult =
        call.receive<CreateUniversityCommand>()
            .run { UpdateUniversityEvent(entity) }
            .let { universityHttpPort.update(it) }

    suspend fun delete(call: RoutingCall): DeleteUniversityResult =
        DeleteUniversityEvent(call.parameters.id)
            .let { universityHttpPort.delete(it) }
}
