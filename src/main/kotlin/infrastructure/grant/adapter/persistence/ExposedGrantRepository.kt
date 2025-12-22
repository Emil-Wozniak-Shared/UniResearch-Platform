package infrastructure.grant.adapter.persistence

import domain.grant.GrantEntity
import kotlinx.datetime.toJavaLocalDate
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import common.Pageable
import java.util.*

class ExposedGrantRepository : GrantRepository {

    override fun findById(id: UUID): GrantEntity? =
        transaction {
            Grants
                .select(Grants.columns)
                .where { Grants.id eq id }
                .map(::toEntity)
                .singleOrNull()
        }

    override fun findAll(pageable: Pageable): List<GrantEntity> =
        transaction {
            Grants
                .select(Grants.columns)
                .limit(pageable.size)
                .offset(pageable.page.toLong() * pageable.size)
                .map(::toEntity)
        }

    override fun create(entity: GrantEntity): GrantEntity =
        transaction {
            Grants.insert {
                it[id] = entity.id
            }
            entity
        }

    override fun update(entity: GrantEntity): GrantEntity =
        transaction {
            Grants.update({ Grants.id eq entity.id }) {
                it[id] = entity.id
            }
            entity
        }

    override fun delete(id: UUID): Boolean =
        transaction {
            Grants.deleteWhere { Grants.id eq id } > 0
        }

    private fun toEntity(row: ResultRow): GrantEntity =
        GrantEntity(
            id = row[Grants.id],
            title = row[Grants.title],
            description = row[Grants.description],
            startDate = row[Grants.startDate].toJavaLocalDate(),
            endDate = row[Grants.endDate]!!.toJavaLocalDate(),
            grantNumber = row[Grants.grantNumber],
            totalAmount = row[Grants.totalAmount],
            currency = row[Grants.currency],
            agencyId = row[Grants.agencyId],
            scientificFieldId = row[Grants.scientificFieldId],
        )
}
