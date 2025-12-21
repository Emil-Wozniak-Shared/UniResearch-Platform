package domain.reagent

import java.util.UUID
import java.time.LocalDate

data class ReagentEntity(
    val id: UUID,
    val name: String,
    val type: String,
    val quantity: Double,
    val unit: String,
    val roomId: UUID,
    val expirationDate: LocalDate
)
