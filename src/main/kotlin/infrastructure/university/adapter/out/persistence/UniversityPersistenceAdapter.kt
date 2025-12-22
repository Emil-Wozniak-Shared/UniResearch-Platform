package infrastructure.university.adapter.out.persistence

import domain.university.UniversityEntity
import infrastructure.university.adapter.out.persistence.exposed.Universities
import infrastructure.university.model.event.*
import infrastructure.university.model.result.*
import infrastructure.university.port.out.persistance.UniversityPersistencePort
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

class UniversityPersistenceAdapter(
    private val db: Database
): UniversityPersistencePort {

    override suspend fun find(event: FindUniversityEvent): FindUniversityResult = transaction(db) {
        val row = Universities
            .select(Universities.columns)
            .where { Universities.id eq event.id }
            .firstOrNull()
            ?: throw NoSuchElementException("University not found")
        FindUniversityResult(
            entity = UniversityEntity(
                id = row[Universities.id],
                name = row[Universities.name],
                type = row[Universities.type],
                locationId = row[Universities.locationId],
                foundedYear = row[Universities.foundedYear],
                scientificFieldId = row[Universities.scientificFieldId]
            )
        )
    }

    override suspend fun list(event: ListUniversityEvent): ListUniversityResult = transaction(db) {
        val offset = event.pageable.page * event.pageable.size
        val query = Universities.selectAll()
            .limit(event.pageable.size)
            .offset(offset.toLong())

        val entities = query.map { row ->
            UniversityEntity(
                id = row[Universities.id],
                name = row[Universities.name],
                type = row[Universities.type],
                locationId = row[Universities.locationId],
                foundedYear = row[Universities.foundedYear],
                scientificFieldId = row[Universities.scientificFieldId]
            )
        }
        ListUniversityResult(entities)
    }

    override suspend fun create(event: CreateUniversityEvent): CreateUniversityResult = transaction(db) {
        Universities.insert {
            it[id] = event.entity.id
            it[name] = event.entity.name
            it[type] = event.entity.type
            it[locationId] = event.entity.locationId
            it[foundedYear] = event.entity.foundedYear
            it[scientificFieldId] = event.entity.scientificFieldId
        }
        CreateUniversityResult(entity = event.entity)
    }

    override suspend fun update(event: UpdateUniversityEvent): UpdateUniversityResult = transaction(db) {
        val updated = Universities.update({ Universities.id eq event.entity.id }) {
            it[name] = event.entity.name
            it[type] = event.entity.type
            it[locationId] = event.entity.locationId
            it[foundedYear] = event.entity.foundedYear
            it[scientificFieldId] = event.entity.scientificFieldId
        }
        if (updated == 0) throw NoSuchElementException("University not found")
        UpdateUniversityResult(entity = event.entity)
    }

    override suspend fun delete(event: DeleteUniversityEvent): DeleteUniversityResult = transaction(db) {
        val deletedCount = Universities.deleteWhere { Universities.id eq event.id }
        DeleteUniversityResult(deleted = deletedCount > 0)
    }
}
