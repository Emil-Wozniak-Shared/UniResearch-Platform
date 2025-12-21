package infrastructure.researcher.adapter.persistence

import domain.researcher.ResearcherEntity
import pl.ejdev.common.Pageable
import java.util.UUID

interface ResearcherRepository {

    fun findById(id: UUID): ResearcherEntity?

    fun findAll(pageable: Pageable): List<ResearcherEntity>

    fun create(entity: ResearcherEntity): ResearcherEntity

    fun update(entity: ResearcherEntity): ResearcherEntity

    fun delete(id: UUID): Boolean
}
