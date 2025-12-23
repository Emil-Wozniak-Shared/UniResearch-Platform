package infrastructure.auth.adapter.out.persistence

import domain.auth.AuthEntity
import common.Pageable
import java.util.UUID

interface AuthRepository {
    suspend   fun findById(id: UUID): AuthEntity?
    suspend fun findAll(pageable: Pageable): List<AuthEntity>
    suspend  fun create(entity: AuthEntity): AuthEntity
    suspend  fun update(entity: AuthEntity): AuthEntity
    suspend fun delete(id: UUID): Boolean

}
