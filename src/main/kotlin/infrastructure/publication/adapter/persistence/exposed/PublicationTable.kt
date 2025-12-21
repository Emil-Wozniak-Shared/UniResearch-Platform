package infrastructure.publication.adapter.persistence.exposed

import infrastructure.scientificField.adapter.persistence.exposed.ScientificFields
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.date
import java.util.UUID

object Publications : Table("publication") {
    val id = uuid("id").autoIncrement()
    val title = varchar("title", 500)
    val abstract = text("abstract").nullable()
    val publicationType = varchar("publication_type", 50)
    val journalOrPublisher = varchar("journal_or_publisher", 255).nullable()
    val doi = varchar("doi", 150).nullable().uniqueIndex()
    val publicationDate = date("publication_date").nullable()
    val scientificFieldId = uuid("scientific_field_id").references(ScientificFields.id)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
