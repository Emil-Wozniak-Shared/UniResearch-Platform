package infrastructure.institution.adapter.http

import common.Pageable
import infrastructure.institution.model.command.*
import infrastructure.institution.model.event.*
import infrastructure.institution.model.result.*
import infrastructure.institution.port.`in`.http.InstitutionHttpPort
import infrastructure.institution.port.out.pdf.InstitutionPdfPort
import infrastructure.institution.port.out.persistance.InstitutionPersistencePort

class InstitutionHttpAdapter(
    private val persistencePort: InstitutionPersistencePort,
    private val pdfPort: InstitutionPdfPort,
) : InstitutionHttpPort {
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

    override suspend fun pdf(command: PdfInstitutionCommand): PdfInstitutionResult = when (command.type) {
        PdfInstitutionType.LIST ->
            list(ListInstitutionCommand(Pageable.default))
                .items.let(::ListPdfInstitutionEvent).let { pdfPort.list(it) }
    }

}
