package infrastructure.publication.model.event

import domain.publication.PublicationEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class FindPublicationEvent(
    val id: java.util.UUID
)
