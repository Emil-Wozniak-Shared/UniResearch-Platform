package domain.researcher

import java.util.UUID

data class ResearcherEntity(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val degree: String,
    val universityId: UUID,
    val instituteId: UUID
)
