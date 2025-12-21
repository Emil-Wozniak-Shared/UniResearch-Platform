package infrastructure.agency.model.result

import domain.agency.AgencyEntity
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class FindAgencyResult(
    val entity: AgencyEntity?
)
