package infrastructure.publication.adapter.persistence.exposed

import infrastructure.researcher.adapter.persistence.Researchers
import org.jetbrains.exposed.sql.Table

object PublicationAuthors : Table("publication_author") {
    val publicationId = uuid("publication_id").references(Publications.id)
    val researcherId = uuid("researcher_id").references(Researchers.id)
    val authorOrder = integer("author_order")
    val isCorrespondingAuthor = bool("is_corresponding_author").default(false)
    override val primaryKey: PrimaryKey = PrimaryKey(publicationId, researcherId)
}
