package infrastructure.reagent.adapter.persistence.exposed

import infrastructure.room.adapter.persistence.exposed.Rooms
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.date
import java.util.UUID

object Reagents : Table("reagent") {
    val id = uuid("id").autoIncrement()
    val name = varchar("name", 255)
    val type = varchar("type", 50)
    val quantity = double("quantity")
    val unit = varchar("unit", 20)
    val roomId = uuid("room_id").references(Rooms.id)
    val expirationDate = date("expiration_date")
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
