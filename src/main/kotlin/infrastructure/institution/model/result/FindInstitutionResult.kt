package infrastructure.institution.model.result

import domain.institution.InstitutionEntity

data class FindInstitutionResult(
    val entity: InstitutionEntity?
)
