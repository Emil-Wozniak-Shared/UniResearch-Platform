package infrastructure.agency.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Agencies : Table("agency") {
    val id = uuid("id").autoIncrement()
    val name = varchar("name", 255)
    val type = varchar("type", 50)
    val activity = varchar("activity", 255)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
