package infrastructure.institution.model.event

import domain.institution.InstitutionEntity

sealed class PdfInstitutionEvent

data class ListPdfInstitutionEvent(val institutions: List<InstitutionEntity>)