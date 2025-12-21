package infrastructure.institution.adapter.persistence

import domain.institution.InstitutionEntity
import pl.ejdev.common.Pageable
import java.util.UUID

interface InstitutionRepository {
    fun findById(id: UUID): InstitutionEntity?
    fun findAll(pageable: Pageable): List<InstitutionEntity>
    fun create(entity: InstitutionEntity): InstitutionEntity
    fun update(entity: InstitutionEntity): InstitutionEntity
    fun delete(id: UUID): Boolean
}
