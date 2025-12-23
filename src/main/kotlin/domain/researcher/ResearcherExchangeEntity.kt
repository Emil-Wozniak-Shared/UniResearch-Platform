package domain.researcher

import java.time.LocalDate
import java.util.UUID

data class ResearcherExchangeEntity(
    val id: UUID,
    val researcherId: UUID,
    val hostUniversityId: UUID,
    val hostInstituteId: UUID,
    val exchangeType: String,
    val status: String,
    val startDate: LocalDate,
    val endDate: LocalDate?
)