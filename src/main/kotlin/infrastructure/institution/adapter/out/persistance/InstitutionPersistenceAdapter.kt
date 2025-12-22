package infrastructure.institution.adapter.out.persistance

import domain.institution.InstitutionEntity
import infrastructure.institution.model.event.*
import infrastructure.institution.model.result.*
import infrastructure.institution.port.out.persistance.InstitutionPersistencePort
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

class InstitutionPersistenceAdapter(
    private val db: Database
) : InstitutionPersistencePort {

    override suspend fun find(event: FindInstitutionEvent): FindInstitutionResult = transaction(db) {
        val row = Institutions
            .select(Institutions.columns)
            .where { Institutions.id eq event.id }
            .firstOrNull()
            ?: throw NoSuchElementException("Institution not found")
        FindInstitutionResult(
            entity = InstitutionEntity(
                id = row[Institutions.id],
                name = row[Institutions.name],
                type = row[Institutions.type],
                locationId = row[Institutions.locationId],
                universityId = row[Institutions.universityId],
                foundedYear = row[Institutions.foundedYear],
                scientificFieldId = row[Institutions.scientificFieldId]
            )
        )
    }

    override suspend fun list(event: ListInstitutionEvent): ListInstitutionResult = transaction(db) {
        val offset = event.pageable.page * event.pageable.size
        val query = Institutions.selectAll()
            .limit(event.pageable.size)
            .offset(offset.toLong())

        val entities = query.map { row ->
            InstitutionEntity(
                id = row[Institutions.id],
                name = row[Institutions.name],
                type = row[Institutions.type],
                locationId = row[Institutions.locationId],
                universityId = row[Institutions.universityId],
                foundedYear = row[Institutions.foundedYear],
                scientificFieldId = row[Institutions.scientificFieldId]
            )
        }
        ListInstitutionResult(entities)
    }

    override suspend fun create(event: CreateInstitutionEvent): CreateInstitutionResult = transaction(db) {
        Institutions.insert {
            it[id] = event.entity.id
            it[name] = event.entity.name
            it[type] = event.entity.type
            it[locationId] = event.entity.locationId
            it[universityId] = event.entity.universityId
            it[foundedYear] = event.entity.foundedYear
            it[scientificFieldId] = event.entity.scientificFieldId
        }
        CreateInstitutionResult(entity = event.entity)
    }

    override suspend fun update(event: UpdateInstitutionEvent): UpdateInstitutionResult = transaction(db) {
        val updated = Institutions.update({ Institutions.id eq event.entity.id }) {
            it[name] = event.entity.name
            it[type] = event.entity.type
            it[locationId] = event.entity.locationId
            it[universityId] = event.entity.universityId
            it[foundedYear] = event.entity.foundedYear
            it[scientificFieldId] = event.entity.scientificFieldId
        }
        if (updated == 0) throw NoSuchElementException("Institution not found")
        UpdateInstitutionResult(entity = event.entity)
    }

    override suspend fun delete(event: DeleteInstitutionEvent): DeleteInstitutionResult = transaction(db) {
        val deletedCount = Institutions.deleteWhere { Institutions.id eq event.id }
        DeleteInstitutionResult(deleted = deletedCount > 0)
    }
}
