package domain.equipment

import java.util.UUID

data class EquipmentEntity(
    val id: UUID,
    val name: String,
    val type: String,
    val roomId: UUID,
    val purchaseYear: Int,
    val status: String
)
