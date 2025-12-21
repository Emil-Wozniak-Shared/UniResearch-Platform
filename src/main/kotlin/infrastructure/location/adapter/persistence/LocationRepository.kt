package infrastructure.location.adapter.persistence

import domain.location.LocationEntity
import pl.ejdev.common.Pageable
import java.util.UUID

interface LocationRepository {
    fun findById(id: UUID): LocationEntity?
    fun findAll(pageable: Pageable): List<LocationEntity>
    fun create(entity: LocationEntity): LocationEntity
    fun update(entity: LocationEntity): LocationEntity
    fun delete(id: UUID): Boolean
}
