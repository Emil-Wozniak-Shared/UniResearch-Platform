package infrastructure.scientificField.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object ScientificFields : Table("scientific_field") {
    val id = uuid("id").autoIncrement()
    val name = varchar("name", 100)
    val description = varchar("description", 255).nullable()
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
