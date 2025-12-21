package domain.agency

import java.util.UUID

data class AgencyEntity(
    val id: UUID,
    val name: String,
    val type: String,
    val activity: String
)
