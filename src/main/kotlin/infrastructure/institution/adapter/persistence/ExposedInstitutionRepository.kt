package infrastructure.institution.adapter.persistence

import domain.institution.InstitutionEntity
import infrastructure.institute.adapter.persistence.exposed.Institutes
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import pl.ejdev.common.Pageable
import java.util.*

class ExposedInstitutionRepository : InstitutionRepository {

    override fun findById(id: UUID): InstitutionEntity? =
        transaction {
            Institutes
                .select(Institutes.columns)
                .where { Institutes.id eq id }
                .map(::toEntity)
                .singleOrNull()
        }

    override fun findAll(pageable: Pageable): List<InstitutionEntity> =
        transaction {
            Institutes
                .select(Institutes.columns)
                .limit(pageable.size)
                .offset(pageable.page.toLong() * pageable.size)
                .map(::toEntity)
        }

    override fun create(entity: InstitutionEntity): InstitutionEntity =
        transaction {
            Institutes.insert {
                it[name] = entity.name
                it[type] = entity.type
                it[locationId] = entity.locationId
                it[universityId] = entity.universityId
                it[foundedYear] = entity.foundedYear
                it[scientificFieldId] = entity.scientificFieldId
            }
            entity
        }

    override fun update(entity: InstitutionEntity): InstitutionEntity =
        transaction {
            Institutes.update({ Institutes.id eq entity.id }) {
                it[name] = entity.name
                it[type] = entity.type
                it[locationId] = entity.locationId
                it[universityId] = entity.universityId
                it[foundedYear] = entity.foundedYear
                it[scientificFieldId] = entity.scientificFieldId
            }
            entity
        }

    override fun delete(id: UUID): Boolean =
        transaction {
            Institutes.deleteWhere { Institutes.id eq id } > 0
        }

    private fun toEntity(row: ResultRow): InstitutionEntity =
        InstitutionEntity(
            id = row[Institutes.id],
            name = row[Institutes.name],
            type = row[Institutes.type],
            locationId = row[Institutes.locationId],
            universityId = row[Institutes.universityId],
            foundedYear = row[Institutes.foundedYear],
            scientificFieldId = row[Institutes.scientificFieldId]
        )
}
