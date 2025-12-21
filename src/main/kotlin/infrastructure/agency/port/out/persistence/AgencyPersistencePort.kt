package pl.ejdev.infrastructure.agency.port.out.persistence

import infrastructure.agency.model.event.*
import infrastructure.agency.model.result.*

interface AgencyPersistencePort {
    suspend fun find(event: FindAgencyEvent): FindAgencyResult

    suspend fun list(event: ListAgencyEvent): ListAgencyResult

    suspend fun create(event: CreateAgencyEvent): CreateAgencyResult

    suspend fun update(event: UpdateAgencyEvent): UpdateAgencyResult

    suspend fun delete(event: DeleteAgencyEvent): DeleteAgencyResult
}