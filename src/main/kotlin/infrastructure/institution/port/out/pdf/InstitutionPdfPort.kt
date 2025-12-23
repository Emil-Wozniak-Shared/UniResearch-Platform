package infrastructure.institution.port.out.pdf

import infrastructure.institution.model.event.ListPdfInstitutionEvent
import infrastructure.institution.model.result.PdfInstitutionResult

interface InstitutionPdfPort {
    suspend fun list(event: ListPdfInstitutionEvent): PdfInstitutionResult
}