package infrastructure.agency.model.result

import domain.agency.AgencyEntity
import kotlinx.serialization.Serializable

@Serializable
data class UpdateAgencyResult(
    val entity: AgencyEntity
)
