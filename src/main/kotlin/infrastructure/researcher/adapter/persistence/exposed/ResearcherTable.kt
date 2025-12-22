package infrastructure.researcher.adapter.persistence.exposed

import infrastructure.institute.adapter.persistence.exposed.Institutes
import infrastructure.university.adapter.out.persistence.exposed.Universities
import org.jetbrains.exposed.sql.Table

object Researchers : Table("researcher") {
    val id = uuid("id")
    val firstName = varchar("first_name", 100)
    val lastName = varchar("last_name", 100)
    val degree = varchar("degree", 50)
    val universityId = uuid("university_id").references(Universities.id)
    val instituteId = uuid("institute_id").references(Institutes.id)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
