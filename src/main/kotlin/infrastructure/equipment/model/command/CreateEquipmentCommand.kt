package infrastructure.equipment.model.command

data class CreateEquipmentCommand(
    val entity: domain.equipment.EquipmentEntity
)
