package infrastructure.agency.port.`in`.http

import infrastructure.agency.model.event.CreateAgencyEvent
import infrastructure.agency.model.event.DeleteAgencyEvent
import infrastructure.agency.model.event.FindAgencyEvent
import infrastructure.agency.model.event.ListAgencyEvent
import infrastructure.agency.model.event.UpdateAgencyEvent
import infrastructure.agency.model.result.CreateAgencyResult
import infrastructure.agency.model.result.DeleteAgencyResult
import infrastructure.agency.model.result.FindAgencyResult
import infrastructure.agency.model.result.ListAgencyResult
import infrastructure.agency.model.result.UpdateAgencyResult

interface AgencyHttpPort {
    suspend fun find(event: FindAgencyEvent): FindAgencyResult
    suspend fun list(event: ListAgencyEvent): ListAgencyResult
    suspend fun create(event: CreateAgencyEvent): CreateAgencyResult
    suspend fun update(event: UpdateAgencyEvent): UpdateAgencyResult
    suspend fun delete(event: DeleteAgencyEvent): DeleteAgencyResult
}
