package infrastructure.auth.adapter.out.persistence

import common.Pageable
import infrastructure.auth.model.event.FindWithRolesAndPermissionsEvent
import infrastructure.auth.model.result.FindWithRolesAndPermissionsResult
import infrastructure.auth.port.out.persistence.UserDetailsRepositoryPort
import infrastructure.user.model.event.FindByUsername
import infrastructure.user.model.event.ListEagerUserRolesEvent
import infrastructure.user.port.out.persistence.UserPersistencePort
import infrastructure.user.port.out.persistence.UserRolePersistencePort
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class UserDetailsRepositoryAdapter(
    private val db: Database,
    private val userPersistencePort: UserPersistencePort,
    private val userRolePersistencePort: UserRolePersistencePort
) : UserDetailsRepositoryPort {
    override suspend fun findWithRolesAndPermissions(
        event: FindWithRolesAndPermissionsEvent
    ): FindWithRolesAndPermissionsResult = newSuspendedTransaction(db = db) {
        val userResult = userPersistencePort.findBy(FindByUsername(event.username), this)
        val user = userResult.user ?: return@newSuspendedTransaction FindWithRolesAndPermissionsResult.None
        val result = userRolePersistencePort.listEager(
            ListEagerUserRolesEvent(user.id, Pageable.default), this
        )
        FindWithRolesAndPermissionsResult.Some(
            user,
            result.roles,
            result.permissions
        )
    }
}