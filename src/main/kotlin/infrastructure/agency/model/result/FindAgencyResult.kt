package infrastructure.agency.model.result

import domain.agency.AgencyEntity
import java.util.UUID

data class FindAgencyResult(
    val entity: AgencyEntity?
)
