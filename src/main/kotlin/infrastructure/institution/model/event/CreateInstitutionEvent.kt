package infrastructure.institution.model.event

data class CreateInstitutionEvent(
    val entity: domain.institution.InstitutionEntity
)
