package infrastructure.agency.model.command

import domain.agency.AgencyEntity
import kotlinx.serialization.Serializable

@Serializable
data class UpdateAgencyCommand(
    val entity: AgencyEntity
)
