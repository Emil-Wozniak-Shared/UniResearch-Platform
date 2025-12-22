package infrastructure.agency.adapter.`in`.http

import infrastructure.agency.model.command.CreateAgencyCommand
import infrastructure.agency.model.command.DeleteAgencyCommand
import infrastructure.agency.model.command.FindAgencyCommand
import infrastructure.agency.model.command.ListAgencyCommand
import infrastructure.agency.model.command.UpdateAgencyCommand
import infrastructure.agency.model.event.CreateAgencyEvent
import infrastructure.agency.model.event.DeleteAgencyEvent
import infrastructure.agency.model.event.FindAgencyEvent
import infrastructure.agency.model.event.ListAgencyEvent
import infrastructure.agency.model.event.UpdateAgencyEvent
import infrastructure.agency.model.result.*
import infrastructure.agency.port.`in`.http.AgencyHttpPort
import pl.ejdev.infrastructure.agency.port.out.persistence.AgencyPersistencePort

class AgencyHttpAdapter(
    private val persistence: AgencyPersistencePort
) : AgencyHttpPort {
    override suspend fun find(command: FindAgencyCommand): FindAgencyResult =
        FindAgencyEvent(command.id).let { persistence.find(it) }

    override suspend fun list(command: ListAgencyCommand): ListAgencyResult =
        ListAgencyEvent(command.pageable).let { persistence.list(it) }

    override suspend fun create(command: CreateAgencyCommand): CreateAgencyResult =
        CreateAgencyEvent(command.entity).let { persistence.create(it) }

    override suspend fun update(command: UpdateAgencyCommand): UpdateAgencyResult =
        UpdateAgencyEvent(command.entity).let { persistence.update(it) }

    override suspend fun delete(command: DeleteAgencyCommand): DeleteAgencyResult =
        DeleteAgencyEvent(command.id).let { persistence.delete(it) }
}