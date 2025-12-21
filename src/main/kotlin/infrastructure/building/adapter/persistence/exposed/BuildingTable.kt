package infrastructure.building.adapter.persistence.exposed

import infrastructure.institute.adapter.persistence.exposed.Institutes
import infrastructure.location.adapter.persistence.exposed.Locations
import infrastructure.university.adapter.persistence.exposed.Universities
import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Buildings : Table("building") {
    val id = uuid("id")
    val name = varchar("name", 255)
    val address = varchar("address", 255)
    val locationId = uuid("location_id").references(Locations.id)
    val universityId = uuid("university_id").references(Universities.id)
    val instituteId = uuid("institute_id").references(Institutes.id)
    val area = double("area")
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
