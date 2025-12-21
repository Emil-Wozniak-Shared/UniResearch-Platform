package infrastructure.equipment.model.result

import domain.equipment.EquipmentEntity
import java.util.UUID

data class UpdateEquipmentResult(
    val entity: domain.equipment.EquipmentEntity
)
