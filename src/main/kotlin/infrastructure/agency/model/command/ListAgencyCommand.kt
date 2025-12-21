package infrastructure.agency.model.command

import kotlinx.serialization.Serializable
import pl.ejdev.common.Pageable

@Serializable
data class ListAgencyCommand(
    val pageable: Pageable
)
