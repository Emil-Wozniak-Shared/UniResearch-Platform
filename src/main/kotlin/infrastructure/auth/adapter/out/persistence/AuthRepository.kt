package infrastructure.auth.adapter.out.persistence

import domain.auth.AuthEntity
import common.Pageable
import java.util.UUID

interface AuthRepository {

    fun findById(id: UUID): AuthEntity?

    fun findAll(pageable: Pageable): List<AuthEntity>

    fun create(entity: AuthEntity): AuthEntity

    fun update(entity: AuthEntity): AuthEntity

    fun delete(id: UUID): Boolean
}
