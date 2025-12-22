package infrastructure.institution.adapter.http

import common.Page
import common.toPage
import domain.institution.InstitutionEntity
import infrastructure.institution.model.command.DeleteInstitutionCommand
import infrastructure.institution.model.command.FindInstitutionCommand
import infrastructure.institution.model.command.ListInstitutionCommand
import infrastructure.institution.model.result.CreateInstitutionResult
import infrastructure.institution.model.result.DeleteInstitutionResult
import infrastructure.institution.model.result.FindInstitutionResult
import infrastructure.institution.model.result.UpdateInstitutionResult
import infrastructure.institution.port.`in`.http.InstitutionHttpPort
import infrastructure.utils.routing.id
import io.ktor.server.application.ApplicationCall
import io.ktor.server.request.receive
import toPageable

class InstitutionHttpHandler(
    private val institutionHttpPort: InstitutionHttpPort
) {

    suspend fun find(call: ApplicationCall): FindInstitutionResult =
        FindInstitutionCommand(call.parameters.id)
            .let { institutionHttpPort.find(it) }

    suspend fun list(call: ApplicationCall): Page<InstitutionEntity> {
        val pageable = call.toPageable()
        return ListInstitutionCommand(pageable)
            .let { institutionHttpPort.list(it) }
            .run { items.toPage(pageable.page, pageable.size, items.size ) }
    }

    suspend fun create(call: ApplicationCall): CreateInstitutionResult =
        institutionHttpPort.create(call.receive())

    suspend fun update(call: ApplicationCall): UpdateInstitutionResult =
        institutionHttpPort.update(call.receive())

    suspend fun delete(call: ApplicationCall): DeleteInstitutionResult =
        DeleteInstitutionCommand(call.parameters.id)
            .let { institutionHttpPort.delete(it) }
}
