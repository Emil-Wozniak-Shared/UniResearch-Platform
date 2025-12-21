package infrastructure.agency.model.command

import domain.agency.AgencyEntity
import kotlinx.serialization.Serializable
import pl.ejdev.common.Pageable
import java.util.UUID

@Serializable
data class UpdateAgencyCommand(
    val entity: AgencyEntity
)
