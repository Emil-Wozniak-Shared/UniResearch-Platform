package infrastructure.institution.adapter.out.persistance

import org.jetbrains.exposed.sql.Table

object Institutions : Table("institution") {

    val id = uuid("id")
    val name = varchar("name", 255)
    val type = varchar("type", 255)
    val locationId = uuid("locationId")
    val universityId = uuid("universityId")
    val foundedYear = integer("foundedYear")
    val scientificFieldId = uuid("scientificFieldId")

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
