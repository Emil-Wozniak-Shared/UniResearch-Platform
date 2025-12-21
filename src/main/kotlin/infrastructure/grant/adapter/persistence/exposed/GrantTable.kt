package infrastructure.grant.adapter.persistence.exposed

import infrastructure.agency.adapter.persistence.exposed.Agencies
import infrastructure.scientificField.adapter.persistence.exposed.ScientificFields
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.date

object Grants : Table("grant") {
    val id = uuid("id")
    val title = varchar("title", 500)
    val description = text("description").nullable()
    val grantNumber = varchar("grant_number", 100).uniqueIndex()
    val startDate = date("start_date")
    val endDate = date("end_date").nullable()
    val totalAmount = decimal("total_amount", 14, 2)
    val currency = varchar("currency", 3)
    val agencyId = uuid("agency_id").references(Agencies.id)
    val scientificFieldId = uuid("scientific_field_id").references(ScientificFields.id)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
