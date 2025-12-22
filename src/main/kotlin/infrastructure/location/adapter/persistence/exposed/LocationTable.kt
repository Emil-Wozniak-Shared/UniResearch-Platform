package infrastructure.location.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table

object Locations : Table("location") {
    val id = uuid("id")
    val name = varchar("name", 100)
    val type = varchar("type", 50)
    val parentLocationId = uuid("parent_location_id").references(Locations.id)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
