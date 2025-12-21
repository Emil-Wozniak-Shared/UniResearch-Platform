package infrastructure.equipment.adapter.persistence.exposed

import infrastructure.room.adapter.persistence.exposed.Rooms
import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Equipment : Table("equipment") {
    val id = uuid("id").autoIncrement()
    val name = varchar("name", 255)
    val type = varchar("type", 50)
    val roomId = uuid("room_id").references(Rooms.id)
    val purchaseYear = integer("purchase_year")
    val status = varchar("status", 50)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
