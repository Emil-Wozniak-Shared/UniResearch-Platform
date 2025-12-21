package infrastructure.agency.model.command

import domain.agency.AgencyEntity
import kotlinx.serialization.Serializable

@Serializable
data class CreateAgencyCommand(
    val entity: AgencyEntity
)
