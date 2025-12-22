package infrastructure.grant.adapter.persistence

import infrastructure.publication.adapter.persistence.exposed.Publications
import org.jetbrains.exposed.sql.Table

object GrantPublications : Table("grant_publication") {
    val grantId = uuid("grant_id").references(Grants.id)
    val publicationId = uuid("publication_id").references(Publications.id)
    override val primaryKey: PrimaryKey = PrimaryKey(grantId, publicationId)
}
