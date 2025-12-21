package pl.ejdev.infrastructure.agency.adapter.out.persistence

import domain.agency.AgencyEntity
import infrastructure.agency.adapter.persistence.exposed.Agencies
import infrastructure.agency.model.event.CreateAgencyEvent
import infrastructure.agency.model.event.DeleteAgencyEvent
import infrastructure.agency.model.event.FindAgencyEvent
import infrastructure.agency.model.event.ListAgencyEvent
import infrastructure.agency.model.event.UpdateAgencyEvent
import infrastructure.agency.model.result.CreateAgencyResult
import infrastructure.agency.model.result.DeleteAgencyResult
import infrastructure.agency.model.result.FindAgencyResult
import infrastructure.agency.model.result.ListAgencyResult
import infrastructure.agency.model.result.UpdateAgencyResult
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import pl.ejdev.infrastructure.agency.port.out.persistence.AgencyPersistencePort
import java.util.NoSuchElementException

class AgencyPersistenceAdapter(
    private val database: Database
) : AgencyPersistencePort {
    override suspend fun find(event: FindAgencyEvent): FindAgencyResult = transaction(db = database) {
        val row = Agencies
            .select(Agencies.columns)
            .where { Agencies.id eq event.id }
            .firstOrNull()
            ?: throw NoSuchElementException("Agency not found")
        FindAgencyResult(
            entity = toEntity(row)
        )
    }

    override suspend fun list(event: ListAgencyEvent): ListAgencyResult = transaction(db = database) {
        val offset = event.pageable.page * event.pageable.size
        val query = Agencies.selectAll()
            .limit(event.pageable.size)
            .offset(offset.toLong())

        val entities = query.map { toEntity(it) }
        ListAgencyResult(entities)
    }


    override suspend fun create(event: CreateAgencyEvent): CreateAgencyResult = transaction(db = database) {
        Agencies.insert {
            it[id] = event.entity.id
            it[name] = event.entity.name
            it[type] = event.entity.type
            it[activity] = event.entity.activity
        }
        CreateAgencyResult(entity = event.entity)
    }

    override suspend fun update(event: UpdateAgencyEvent): UpdateAgencyResult = transaction(db = database) {
        val updated = Agencies.update({ Agencies.id eq event.entity.id }) {
            it[name] = event.entity.name
            it[type] = event.entity.type
            it[activity] = event.entity.activity
        }
        if (updated == 0) throw NoSuchElementException("Agency not found")
        UpdateAgencyResult(entity = event.entity)
    }

    override suspend fun delete(event: DeleteAgencyEvent): DeleteAgencyResult = transaction(db = database) {
        val deletedCount = Agencies.deleteWhere { Agencies.id eq event.id }
        val deleted = deletedCount > 0
        DeleteAgencyResult(deleted = deleted)
    }
    
    private fun toEntity(row: ResultRow): AgencyEntity = AgencyEntity(
        id = row[Agencies.id],
        name = row[Agencies.name],
        type = row[Agencies.type],
        activity = row[Agencies.activity]
    )
}