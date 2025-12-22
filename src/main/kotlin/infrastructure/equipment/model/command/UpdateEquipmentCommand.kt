package infrastructure.equipment.model.command

data class UpdateEquipmentCommand(
    val entity: domain.equipment.EquipmentEntity
)
