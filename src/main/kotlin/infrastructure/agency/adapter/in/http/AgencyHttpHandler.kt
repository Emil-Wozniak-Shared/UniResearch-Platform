package infrastructure.agency.adapter.`in`.http

import infrastructure.agency.model.command.*
import infrastructure.agency.model.event.*
import infrastructure.agency.model.result.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import infrastructure.agency.port.`in`.http.AgencyHttpPort
import infrastructure.utils.routing.id
import pl.ejdev.toPageable

class AgencyHttpHandler(
    private val agencyHttpPort: AgencyHttpPort
) {
    suspend fun find(call: RoutingCall): FindAgencyResult =
        FindAgencyCommand(call.parameters.id)
            .run { FindAgencyEvent(id) }
            .let { agencyHttpPort.find(it) }

    suspend fun list(call: RoutingCall): ListAgencyResult =
        ListAgencyCommand(call.toPageable())
            .run { ListAgencyEvent(pageable) }
            .let { agencyHttpPort.list(it) }

    suspend fun create(call: RoutingCall): CreateAgencyResult =
        call.receive<CreateAgencyCommand>()
            .run { CreateAgencyEvent(entity) }
            .let { agencyHttpPort.create(it) }

    suspend fun update(call: RoutingCall): UpdateAgencyResult =
        call.receive<UpdateAgencyCommand>()
            .run { UpdateAgencyEvent(entity) }
            .let { agencyHttpPort.update(it) }

    suspend fun delete(call: RoutingCall): DeleteAgencyResult =
        DeleteAgencyCommand(call.parameters.id)
            .run { DeleteAgencyEvent(id) }
            .let { agencyHttpPort.delete(it) }
}