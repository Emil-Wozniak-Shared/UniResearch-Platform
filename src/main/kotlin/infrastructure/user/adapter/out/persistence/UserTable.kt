package infrastructure.user.adapter.out.persistence

import infrastructure.researcher.adapter.persistence.Researchers
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Users : Table("user") {
    val id = uuid("id")
    val username = varchar("username", 50).uniqueIndex()
    val email = varchar("email", 100).uniqueIndex()
    val passwordHash = varchar("password_hash", 255)
    val researcherId: Column<UUID?> = optReference("researcher_id",Researchers.id)

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
