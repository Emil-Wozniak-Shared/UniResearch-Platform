package infrastructure.publication.adapter.persistence

import domain.publication.PublicationEntity
import common.Pageable
import java.util.UUID

interface PublicationRepository {

    fun findById(id: UUID): PublicationEntity?

    fun findAll(pageable: Pageable): List<PublicationEntity>

    fun create(entity: PublicationEntity): PublicationEntity

    fun update(entity: PublicationEntity): PublicationEntity

    fun delete(id: UUID): Boolean
}
