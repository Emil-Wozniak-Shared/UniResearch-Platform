package infrastructure.grant.adapter.persistence

import domain.grant.GrantEntity
import common.Pageable
import java.util.UUID

interface GrantRepository {

    fun findById(id: UUID): GrantEntity?

    fun findAll(pageable: Pageable): List<GrantEntity>

    fun create(entity: GrantEntity): GrantEntity

    fun update(entity: GrantEntity): GrantEntity

    fun delete(id: UUID): Boolean
}
