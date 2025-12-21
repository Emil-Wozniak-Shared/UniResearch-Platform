package infrastructure.equipment.model.result

import domain.equipment.EquipmentEntity
import java.util.UUID

data class FindEquipmentResult(
    val entity: EquipmentEntity?
)
