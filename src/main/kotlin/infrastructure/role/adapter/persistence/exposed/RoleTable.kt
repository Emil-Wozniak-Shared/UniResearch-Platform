package infrastructure.role.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Roles : Table("role") {
    val id = uuid("id")
    val name = varchar("name", 50)
    val description = varchar("description", 255).nullable()
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
