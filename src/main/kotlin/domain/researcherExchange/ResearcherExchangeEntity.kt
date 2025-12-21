package domain.researcherExchange

import java.util.UUID
import java.time.LocalDate

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
