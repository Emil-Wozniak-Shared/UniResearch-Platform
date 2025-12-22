package infrastructure.grantParticipant.adapter.persistence.exposed

import infrastructure.grant.adapter.persistence.exposed.Grants
import infrastructure.researcher.adapter.persistence.Researchers
import org.jetbrains.exposed.sql.Table

object GrantParticipants : Table("grant_participant") {
    val grantId = uuid("grant_id").references(Grants.id)
    val researcherId = uuid("researcher_id").references(Researchers.id)
    val role = varchar("role", 30)
    val participationPercent = decimal("participation_percent", 5, 2).nullable()
    override val primaryKey: PrimaryKey = PrimaryKey(grantId, researcherId)
}
