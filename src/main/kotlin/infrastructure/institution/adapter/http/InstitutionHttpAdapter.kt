package infrastructure.institution.adapter.http

import infrastructure.institution.model.command.CreateInstitutionCommand
import infrastructure.institution.model.command.DeleteInstitutionCommand
import infrastructure.institution.model.command.FindInstitutionCommand
import infrastructure.institution.model.command.ListInstitutionCommand
import infrastructure.institution.model.command.UpdateInstitutionCommand
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
import infrastructure.institution.port.`in`.http.InstitutionHttpPort
import infrastructure.institution.port.out.persistance.InstitutionPersistencePort

class InstitutionHttpAdapter(
    private val persistencePort: InstitutionPersistencePort,
): InstitutionHttpPort {
    override suspend fun find(command: FindInstitutionCommand): FindInstitutionResult =
        FindInstitutionEvent(command.id).let { persistencePort.find(it) }

    override suspend fun list(command: ListInstitutionCommand): ListInstitutionResult =
        ListInstitutionEvent(command.pageable).let { persistencePort.list(it) }

    override suspend fun create(command: CreateInstitutionCommand): CreateInstitutionResult =
        CreateInstitutionEvent(command.entity).let { persistencePort.create(it) }

    override suspend fun update(command: UpdateInstitutionCommand): UpdateInstitutionResult =
        UpdateInstitutionEvent(command.entity).let { persistencePort.update(it) }

    override suspend fun delete(command: DeleteInstitutionCommand): DeleteInstitutionResult =
        DeleteInstitutionEvent(command.id).let { persistencePort.delete(it) }

}
