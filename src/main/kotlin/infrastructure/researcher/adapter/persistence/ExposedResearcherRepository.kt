package infrastructure.researcher.adapter.persistence

import domain.researcher.ResearcherEntity
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import common.Pageable
import java.util.*

class ExposedResearcherRepository : ResearcherRepository {

    override fun findById(id: UUID): ResearcherEntity? =
        transaction {
            Researchers
                .select(Researchers.columns)
                .where { Researchers.id eq id }
                .map(::toEntity)
                .singleOrNull()
        }

    override fun findAll(pageable: Pageable): List<ResearcherEntity> =
        transaction {
            Researchers
                .select(Researchers.columns)
                .limit(pageable.size)
                .offset(pageable.page.toLong() * pageable.size)
                .map(::toEntity)
        }

    override fun create(entity: ResearcherEntity): ResearcherEntity =
        transaction {
            Researchers.insert {
                it[id] = entity.id
            }
            entity
        }

    override fun update(entity: ResearcherEntity): ResearcherEntity =
        transaction {
            Researchers.update({ Researchers.id eq entity.id }) {
                it[id] = entity.id
            }
            entity
        }

    override fun delete(id: UUID): Boolean =
        transaction {
            Researchers.deleteWhere { Researchers.id eq id } > 0
        }

    private fun toEntity(row: ResultRow): ResearcherEntity =
        ResearcherEntity(
            id = row[Researchers.id],
            firstName = row[Researchers.firstName],
            lastName = row[Researchers.lastName],
            degree = row[Researchers.degree],
            universityId = row[Researchers.universityId],
            instituteId = row[Researchers.instituteId],
        )
}
