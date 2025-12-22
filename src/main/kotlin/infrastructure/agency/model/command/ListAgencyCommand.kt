package infrastructure.agency.model.command

import kotlinx.serialization.Serializable
import common.Pageable

@Serializable
data class ListAgencyCommand(
    val pageable: Pageable
)
