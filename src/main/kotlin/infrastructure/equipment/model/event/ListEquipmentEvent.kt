package infrastructure.equipment.model.event

import domain.equipment.EquipmentEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class ListEquipmentEvent(
    val pageable: pl.ejdev.common.Pageable
)
