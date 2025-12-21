package infrastructure.permission.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Permissions : Table("permission") {
    val id = uuid("id")
    val name = varchar("name", 100)
    val description = varchar("description", 255).nullable()
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
