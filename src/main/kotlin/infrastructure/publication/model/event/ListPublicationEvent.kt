package infrastructure.publication.model.event

import domain.publication.PublicationEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class ListPublicationEvent(
    val pageable: pl.ejdev.common.Pageable
)
