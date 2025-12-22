package infrastructure.scientificField.model.event

data class UpdateScientificFieldEvent(
    val entity: domain.scientificField.ScientificFieldEntity
)
