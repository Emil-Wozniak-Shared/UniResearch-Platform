package infrastructure.user.adapter.persistence.exposed

import infrastructure.researcher.adapter.persistence.exposed.Researchers
import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Users : Table("user") {
    val id = uuid("id").autoIncrement()
    val username = varchar("username", 50).uniqueIndex()
    val email = varchar("email", 100).uniqueIndex()
    val passwordHash = varchar("password_hash", 255)
    val researcherId = uuid("researcher_id").references(Researchers.id)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
