package infrastructure.scientificField.model.event

data class CreateScientificFieldEvent(
    val entity: domain.scientificField.ScientificFieldEntity
)
