package infrastructure.permission.adapter.out.persistence

import domain.permission.PermissionEntity
import infrastructure.permission.model.event.CreatePermissionEvent
import infrastructure.permission.model.event.DeletePermissionEvent
import infrastructure.permission.model.event.FindPermissionEvent
import infrastructure.permission.model.event.ListPermissionEvent
import infrastructure.permission.model.event.UpdatePermissionEvent
import infrastructure.permission.model.result.CreatePermissionResult
import infrastructure.permission.model.result.DeletePermissionResult
import infrastructure.permission.model.result.FindPermissionResult
import infrastructure.permission.model.result.ListPermissionResult
import infrastructure.permission.model.result.UpdatePermissionResult
import infrastructure.permission.port.out.persistence.PermissionPersistencePort
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

class PermissionPersistenceAdapter(private val db: Database) : PermissionPersistencePort {

    override suspend fun find(event: FindPermissionEvent): FindPermissionResult = transaction(db) {
        Permissions.select ( Permissions.id eq event.id )
            .firstOrNull()
            ?.toEntity()
            ?.let { FindPermissionResult(it) }
            ?: throw NoSuchElementException("Permission not found")
    }

    override suspend fun list(event: ListPermissionEvent): ListPermissionResult = transaction(db) {
        val offset = event.pageable.page * event.pageable.size
        val query = Permissions.selectAll()
            .limit(event.pageable.size)
            .offset(offset.toLong())
        ListPermissionResult(query.map { it.toEntity() })
    }

    override suspend fun create(event: CreatePermissionEvent): CreatePermissionResult = transaction(db) {
        val entity = event.entity
        Permissions.insert {
            it[id] = entity.id
            it[name] = entity.name
            it[description] = entity.description
        }
        CreatePermissionResult(entity)
    }

    override suspend fun update(event: UpdatePermissionEvent): UpdatePermissionResult = transaction(db) {
        val entity = event.entity
        val updated = Permissions.update({ Permissions.id eq entity.id }) {
            it[name] = entity.name
            it[description] = entity.description
        }
        if (updated == 0) throw NoSuchElementException("Permission not found")
        UpdatePermissionResult(entity)
    }

    override suspend fun delete(event: DeletePermissionEvent): DeletePermissionResult = transaction(db) {
        val deleted = Permissions.deleteWhere { Permissions.id eq event.id }
        DeletePermissionResult(deleted > 0)
    }

    private fun ResultRow.toEntity() = PermissionEntity(
        id = this[Permissions.id],
        name = this[Permissions.name],
        description = this[Permissions.description]
    )
}