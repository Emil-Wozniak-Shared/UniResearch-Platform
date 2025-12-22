package infrastructure.institution.model.event

data class UpdateInstitutionEvent(
    val entity: domain.institution.InstitutionEntity
)
