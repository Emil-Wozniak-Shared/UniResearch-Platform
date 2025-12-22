package infrastructure.equipment.model.event

data class CreateEquipmentEvent(
    val entity: domain.equipment.EquipmentEntity
)
