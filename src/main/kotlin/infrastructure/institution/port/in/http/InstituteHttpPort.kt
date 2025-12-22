package infrastructure.institution.port.`in`.http

import infrastructure.institution.model.command.CreateInstitutionCommand
import infrastructure.institution.model.command.DeleteInstitutionCommand
import infrastructure.institution.model.command.FindInstitutionCommand
import infrastructure.institution.model.command.ListInstitutionCommand
import infrastructure.institution.model.command.UpdateInstitutionCommand
import infrastructure.institution.model.result.CreateInstitutionResult
import infrastructure.institution.model.result.DeleteInstitutionResult
import infrastructure.institution.model.result.FindInstitutionResult
import infrastructure.institution.model.result.ListInstitutionResult
import infrastructure.institution.model.result.UpdateInstitutionResult

interface InstitutionHttpPort {
    suspend fun find(command: FindInstitutionCommand): FindInstitutionResult
    suspend fun list(command: ListInstitutionCommand): ListInstitutionResult
    suspend fun create(command: CreateInstitutionCommand): CreateInstitutionResult
    suspend fun update(command: UpdateInstitutionCommand): UpdateInstitutionResult
    suspend fun delete(command: DeleteInstitutionCommand): DeleteInstitutionResult
}
