package pl.ejdev.infrastructure.agency.adapter.`in`.http

import infrastructure.agency.model.event.*
import infrastructure.agency.model.result.*
import pl.ejdev.infrastructure.agency.port.`in`.http.AgencyHttpPort
import pl.ejdev.infrastructure.agency.port.out.persistence.AgencyPersistencePort

class AgencyHttpAdapter(
    private val persistence: AgencyPersistencePort
) : AgencyHttpPort {

    override suspend fun find(event: FindAgencyEvent): FindAgencyResult {
        return persistence.find(event)
    }

    override suspend fun list(event: ListAgencyEvent): ListAgencyResult {
        return persistence.list(event)
    }

    override suspend fun create(event: CreateAgencyEvent): CreateAgencyResult {
        return persistence.create(event)
    }

    override suspend fun update(event: UpdateAgencyEvent): UpdateAgencyResult {
        return persistence.update(event)
    }

    override suspend fun delete(event: DeleteAgencyEvent): DeleteAgencyResult {
        return persistence.delete(event)
    }
}