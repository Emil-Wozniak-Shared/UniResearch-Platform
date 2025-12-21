package infrastructure.agency.model.command

import domain.agency.AgencyEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class FindAgencyCommand(
    val id: java.util.UUID
)
