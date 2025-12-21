package infrastructure.equipment.model.event

import domain.equipment.EquipmentEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class UpdateEquipmentEvent(
    val entity: domain.equipment.EquipmentEntity
)
