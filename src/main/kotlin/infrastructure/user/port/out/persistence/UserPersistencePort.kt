package infrastructure.user.port.out.persistence

import infrastructure.user.model.event.CreateUserEvent
import infrastructure.user.model.event.DeleteUserEvent
import infrastructure.user.model.event.FindByUserEvent
import infrastructure.user.model.event.FindUserEvent
import infrastructure.user.model.event.ListUserEvent
import infrastructure.user.model.event.UpdateUserEvent
import infrastructure.user.model.result.*
import org.jetbrains.exposed.sql.Transaction

interface UserPersistencePort {
    suspend fun find(event: FindUserEvent): FindUserResult
    suspend fun list(event: ListUserEvent): ListUserResult
    suspend fun create(event: CreateUserEvent): CreateUserResult
    suspend fun update(event: UpdateUserEvent): UpdateUserResult
    suspend fun delete(event: DeleteUserEvent): DeleteUserResult
    suspend fun findBy(event: FindByUserEvent, tx: Transaction): FindByUserResult

}