package infrastructure.agency.model.result

import domain.agency.AgencyEntity
import java.util.UUID

data class ListAgencyResult(
    val entities: List<AgencyEntity>
)
