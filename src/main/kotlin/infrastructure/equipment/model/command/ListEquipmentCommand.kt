package infrastructure.equipment.model.command

import common.Pageable

data class ListEquipmentCommand(
    val pageable: Pageable
)
