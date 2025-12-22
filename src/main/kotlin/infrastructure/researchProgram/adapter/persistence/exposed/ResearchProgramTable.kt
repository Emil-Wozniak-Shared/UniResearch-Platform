package infrastructure.researchProgram.adapter.persistence.exposed

import infrastructure.agency.adapter.persistence.exposed.Agencies
import infrastructure.institution.adapter.out.persistance.Institutions
import org.jetbrains.exposed.sql.Table

object ResearchPrograms : Table("research_program") {
    val id = uuid("id")
    val name = varchar("name", 255)
    val type = varchar("type", 50)
    val instituteId = uuid("institute_id").references(Institutions.id)
    val agencyId = uuid("agency_id").references(Agencies.id)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
