package infrastructure.publication.model.event

import common.Pageable

data class ListPublicationEvent(
    val pageable: Pageable
)
