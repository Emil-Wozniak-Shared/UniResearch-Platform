package domain.researcher

import java.util.UUID

data class ResearchProgramEntity(
    val id: UUID,
    val name: String,
    val type: String,
    val instituteId: UUID,
    val agencyId: UUID
)