package infrastructure.institute.adapter.persistence.exposed

import infrastructure.location.adapter.persistence.exposed.Locations
import infrastructure.scientificField.adapter.persistence.exposed.ScientificFields
import infrastructure.university.adapter.persistence.exposed.Universities
import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Institutes : Table("institute") {
    val id = uuid("id").autoIncrement()
    val name = varchar("name", 255)
    val type = varchar("type", 50)
    val locationId = uuid("location_id").references(Locations.id)
    val universityId = uuid("university_id").references(Universities.id)
    val foundedYear = integer("founded_year")
    val scientificFieldId = uuid("scientific_field_id").references(ScientificFields.id)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
