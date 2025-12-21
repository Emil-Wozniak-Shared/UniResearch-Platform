package infrastructure.publication.adapter.persistence

import domain.publication.PublicationEntity
import infrastructure.publication.adapter.persistence.exposed.Publications
import kotlinx.datetime.toJavaLocalDate
import kotlinx.html.InputType
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import pl.ejdev.common.Pageable
import java.util.UUID

class ExposedPublicationRepository : PublicationRepository {

    override fun findById(id: UUID): PublicationEntity? =
        transaction {
            Publications
                .select(Publications.columns)
                .where { Publications.id eq id }
                .map(::toEntity)
                .singleOrNull()
        }

    override fun findAll(pageable: Pageable): List<PublicationEntity> =
        transaction {
            Publications
                .select(Publications.columns)
                   .limit(pageable.size)
   .offset(pageable.page.toLong() * pageable.size)
                .map(::toEntity)
        }

    override fun create(entity: PublicationEntity): PublicationEntity =
        transaction {
            Publications.insert {
                it[id] = entity.id
            }
            entity
        }

    override fun update(entity: PublicationEntity): PublicationEntity =
        transaction {
            Publications.update({ Publications.id eq entity.id }) {
                it[id] = entity.id
            }
            entity
        }

    override fun delete(id: UUID): Boolean =
        transaction {
            Publications.deleteWhere { Publications.id eq id } > 0
        }

    private fun toEntity(row: ResultRow): PublicationEntity =
        PublicationEntity(
            id = row[Publications.id],
            title = row[Publications.title],
            abstract = row[Publications.abstract],
            publicationDate = row[Publications.publicationDate]?.toJavaLocalDate(),
            journalOrPublisher = row[Publications.journalOrPublisher],
            publicationType = row[Publications.publicationType],
            doi = row[Publications.doi],
            scientificFieldId = row[Publications.scientificFieldId],
        )
}
