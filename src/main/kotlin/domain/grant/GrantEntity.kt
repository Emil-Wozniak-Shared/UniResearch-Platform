package domain.grant

import java.util.UUID
import java.math.BigDecimal
import java.time.LocalDate

data class GrantEntity(
    val id: UUID,
    val title: String,
    val description: String?,
    val grantNumber: String,
    val startDate: LocalDate,
    val endDate: LocalDate?,
    val totalAmount: BigDecimal,
    val currency: String,
    val agencyId: UUID,
    val scientificFieldId: UUID
)
