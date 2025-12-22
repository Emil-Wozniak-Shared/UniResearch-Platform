package infrastructure.agency.port.`in`.http

import infrastructure.agency.model.command.CreateAgencyCommand
import infrastructure.agency.model.command.DeleteAgencyCommand
import infrastructure.agency.model.command.FindAgencyCommand
import infrastructure.agency.model.command.ListAgencyCommand
import infrastructure.agency.model.command.UpdateAgencyCommand
import infrastructure.agency.model.result.CreateAgencyResult
import infrastructure.agency.model.result.DeleteAgencyResult
import infrastructure.agency.model.result.FindAgencyResult
import infrastructure.agency.model.result.ListAgencyResult
import infrastructure.agency.model.result.UpdateAgencyResult

interface AgencyHttpPort {
    suspend fun find(command: FindAgencyCommand): FindAgencyResult
    suspend fun list(command: ListAgencyCommand): ListAgencyResult
    suspend fun create(command: CreateAgencyCommand): CreateAgencyResult
    suspend fun update(command: UpdateAgencyCommand): UpdateAgencyResult
    suspend fun delete(command: DeleteAgencyCommand): DeleteAgencyResult
}
