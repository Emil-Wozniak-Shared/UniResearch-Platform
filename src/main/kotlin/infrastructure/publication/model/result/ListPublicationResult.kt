package infrastructure.publication.model.result

import domain.publication.PublicationEntity
import java.util.UUID

data class ListPublicationResult(
    val entities: List<PublicationEntity>
)
