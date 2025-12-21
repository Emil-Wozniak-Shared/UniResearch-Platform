package infrastructure.grantPublication.adapter.persistence.exposed

import infrastructure.grant.adapter.persistence.exposed.Grants
import infrastructure.publication.adapter.persistence.exposed.Publications
import org.jetbrains.exposed.sql.Table
import java.util.UUID

object GrantPublications : Table("grant_publication") {
    val grantId = uuid("grant_id").references(Grants.id)
    val publicationId = uuid("publication_id").references(Publications.id)
    override val primaryKey: PrimaryKey = PrimaryKey(grantId, publicationId)
}
