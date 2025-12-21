package infrastructure.agency.model.event

import domain.agency.AgencyEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class ListAgencyEvent(
    val pageable: pl.ejdev.common.Pageable
)
