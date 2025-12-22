package infrastructure.institution.port.out.persistance

import infrastructure.institution.model.event.CreateInstitutionEvent
import infrastructure.institution.model.event.DeleteInstitutionEvent
import infrastructure.institution.model.event.FindInstitutionEvent
import infrastructure.institution.model.event.ListInstitutionEvent
import infrastructure.institution.model.event.UpdateInstitutionEvent
import infrastructure.institution.model.result.CreateInstitutionResult
import infrastructure.institution.model.result.DeleteInstitutionResult
import infrastructure.institution.model.result.FindInstitutionResult
import infrastructure.institution.model.result.ListInstitutionResult
import infrastructure.institution.model.result.UpdateInstitutionResult

interface InstitutionPersistencePort {
    suspend fun find(event: FindInstitutionEvent): FindInstitutionResult
    suspend fun list(event: ListInstitutionEvent): ListInstitutionResult
    suspend fun create(event: CreateInstitutionEvent): CreateInstitutionResult
    suspend fun update(event: UpdateInstitutionEvent): UpdateInstitutionResult
    suspend fun delete(event: DeleteInstitutionEvent): DeleteInstitutionResult
}