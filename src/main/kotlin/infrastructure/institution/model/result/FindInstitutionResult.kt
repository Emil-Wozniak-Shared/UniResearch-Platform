package infrastructure.institution.model.result

import domain.institution.InstitutionEntity
import kotlinx.serialization.Serializable

@Serializable
data class FindInstitutionResult(
    val entity: InstitutionEntity?
)
