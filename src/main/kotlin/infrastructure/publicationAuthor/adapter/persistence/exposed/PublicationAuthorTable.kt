package infrastructure.publicationAuthor.adapter.persistence.exposed

import infrastructure.publication.adapter.persistence.exposed.Publications
import infrastructure.researcher.adapter.persistence.exposed.Researchers
import org.jetbrains.exposed.sql.Table
import java.util.UUID

object PublicationAuthors : Table("publication_author") {
    val publicationId = uuid("publication_id").references(Publications.id)
    val researcherId = uuid("researcher_id").references(Researchers.id)
    val authorOrder = integer("author_order")
    val isCorrespondingAuthor = bool("is_corresponding_author").default(false)
    override val primaryKey: PrimaryKey = PrimaryKey(publicationId, researcherId)
}
