package infrastructure.publication.model.command

import domain.publication.PublicationEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class DeletePublicationCommand(
    val id: java.util.UUID
)
