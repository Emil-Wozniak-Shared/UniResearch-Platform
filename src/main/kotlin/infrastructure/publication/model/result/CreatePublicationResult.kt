package infrastructure.publication.model.result

import domain.publication.PublicationEntity
import java.util.UUID

data class CreatePublicationResult(
    val entity: domain.publication.PublicationEntity
)
