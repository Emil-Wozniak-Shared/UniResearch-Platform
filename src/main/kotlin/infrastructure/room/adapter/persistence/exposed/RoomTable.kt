package infrastructure.room.adapter.persistence.exposed

import infrastructure.building.adapter.persistence.exposed.Buildings
import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Rooms : Table("room") {
    val id = uuid("id")
    val number = varchar("number", 50)
    val type = varchar("type", 50)
    val buildingId = uuid("building_id").references(Buildings.id)
    val area = double("area")
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
