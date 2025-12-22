package infrastructure.university.adapter.out.persistence.exposed

import infrastructure.location.adapter.persistence.exposed.Locations
import infrastructure.scientificField.adapter.persistence.exposed.ScientificFields
import org.jetbrains.exposed.sql.Table

object Universities : Table("university") {
    val id = uuid("id")
    val name = varchar("name", 255)
    val type = varchar("type", 50)
    val locationId = uuid("location_id").references(Locations.id)
    val foundedYear = integer("founded_year")
    val scientificFieldId = uuid("scientific_field_id").references(ScientificFields.id)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
