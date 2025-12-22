package infrastructure.institution.model.result

import domain.institution.InstitutionEntity
import kotlinx.serialization.Serializable

@Serializable
data class UpdateInstitutionResult(
    val entity: InstitutionEntity
)
