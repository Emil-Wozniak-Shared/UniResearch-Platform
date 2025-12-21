package infrastructure.agency.model.event

import domain.agency.AgencyEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class DeleteAgencyEvent(
    val id: java.util.UUID
)
