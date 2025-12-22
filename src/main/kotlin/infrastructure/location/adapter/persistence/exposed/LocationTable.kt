package infrastructure.location.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import java.util.*

object Locations : Table("location") {
    val id: Column<UUID> = uuid("id") // primary key, non-nullable
    val name = varchar("name", 100)
    val type = varchar("type", 50)
    val parentLocationId: Column<UUID?> = optReference("parent_location_id", id)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}