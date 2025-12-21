package infrastructure.equipment.model.command

import domain.equipment.EquipmentEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class UpdateEquipmentCommand(
    val entity: domain.equipment.EquipmentEntity
)
