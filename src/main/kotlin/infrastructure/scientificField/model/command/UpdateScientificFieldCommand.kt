package infrastructure.scientificField.model.command

data class UpdateScientificFieldCommand(
    val entity: domain.scientificField.ScientificFieldEntity
)
