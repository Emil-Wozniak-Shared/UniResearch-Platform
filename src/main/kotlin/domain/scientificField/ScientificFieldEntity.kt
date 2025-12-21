package domain.scientificField

import java.util.UUID

data class ScientificFieldEntity(
    val id: UUID,
    val name: String,
    val description: String?
)
