package infrastructure.publication.model.event

import domain.publication.PublicationEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class UpdatePublicationEvent(
    val entity: domain.publication.PublicationEntity
)
