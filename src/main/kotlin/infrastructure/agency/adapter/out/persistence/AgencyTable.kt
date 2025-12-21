package infrastructure.agency.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table

object Agencies : Table("agency") {
    val id = uuid("id")
    val name = varchar("name", 255)
    val type = varchar("type", 50)
    val activity = varchar("activity", 255)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
