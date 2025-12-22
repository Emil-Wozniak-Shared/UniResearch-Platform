package infrastructure.researcherExchange.adapter.persistence.exposed

import infrastructure.institution.adapter.out.persistance.Institutions
import infrastructure.researcher.adapter.persistence.exposed.Researchers
import infrastructure.university.adapter.out.persistence.exposed.Universities
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.date

object ResearcherExchanges : Table("researcher_exchange") {
    val id = uuid("id")
    val researcherId = uuid("researcher_id").references(Researchers.id)
    val hostUniversityId = uuid("host_university_id").references(Universities.id)
    val hostInstituteId = uuid("host_institute_id").references(Institutions.id)
    val exchangeType = varchar("exchange_type", 50)
    val status = varchar("status", 30)
    val startDate = date("start_date")
    val endDate = date("end_date").nullable()
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
