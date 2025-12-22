package infrastructure.publication.model.command

import common.Pageable

data class ListPublicationCommand(
    val pageable: Pageable
)
