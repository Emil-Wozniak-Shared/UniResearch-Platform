package infrastructure.institution.model.result

import kotlinx.serialization.Serializable

@Serializable
data class DeleteInstitutionResult(
    val deleted: Boolean
)
