package infrastructure.agency.adapter.`in`.http

import infrastructure.agency.model.event.*
import infrastructure.agency.model.result.*
import infrastructure.agency.port.`in`.http.AgencyHttpPort
import pl.ejdev.infrastructure.agency.port.out.persistence.AgencyPersistencePort

class AgencyHttpAdapter(
    private val persistence: AgencyPersistencePort
) : AgencyHttpPort {
    override suspend fun find(event: FindAgencyEvent): FindAgencyResult = persistence.find(event)
    override suspend fun list(event: ListAgencyEvent): ListAgencyResult = persistence.list(event)
    override suspend fun create(event: CreateAgencyEvent): CreateAgencyResult = persistence.create(event)
    override suspend fun update(event: UpdateAgencyEvent): UpdateAgencyResult = persistence.update(event)
    override suspend fun delete(event: DeleteAgencyEvent): DeleteAgencyResult = persistence.delete(event)
}