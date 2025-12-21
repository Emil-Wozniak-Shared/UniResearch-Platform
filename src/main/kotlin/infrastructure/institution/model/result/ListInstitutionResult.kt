package infrastructure.institution.model.result

import domain.institution.InstitutionEntity

data class ListInstitutionResult(
    val items: List<InstitutionEntity>
)
