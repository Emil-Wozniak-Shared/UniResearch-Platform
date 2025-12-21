package infrastructure.agency.model.result

import domain.agency.AgencyEntity
import java.util.UUID

data class UpdateAgencyResult(
    val entity: domain.agency.AgencyEntity
)
