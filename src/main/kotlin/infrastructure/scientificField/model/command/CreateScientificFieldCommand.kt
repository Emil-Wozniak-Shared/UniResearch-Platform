package infrastructure.scientificField.model.command

data class CreateScientificFieldCommand(
    val entity: domain.scientificField.ScientificFieldEntity
)
