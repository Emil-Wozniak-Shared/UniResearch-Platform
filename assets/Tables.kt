package persistance

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.date

// ===========================
// LOCATION
// ===========================
object Locations : Table("location") {
    val id = uuid("id")
    val name = varchar("name", 100)
    val type = varchar("type", 50) // country / city / campus
    val parentLocationId = uuid("parent_location_id").references(Locations.id)

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}

// ===========================
// SCIENTIFIC FIELD
// ===========================
object ScientificFields : Table("scientific_field") {
    val id = uuid("id")
    val name = varchar("name", 100)
    val description = varchar("description", 255).nullable()

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}

// ===========================
// AGENCY
// ===========================
object Agencies : Table("agency") {
    val id = uuid("id")
    val name = varchar("name", 255)
    val type = varchar("type", 50) // NCN / NCBR / FNP / EU
    val activity = varchar("activity", 255)

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}

// ===========================
// UNIVERSITY
// ===========================
object Universities : Table("university") {
    val id = uuid("id")
    val name = varchar("name", 255)
    val type = varchar("type", 50)
    val locationId = uuid("location_id").references(Locations.id)
    val foundedYear = integer("founded_year")
    val scientificFieldId = uuid("scientific_field_id").references(ScientificFields.id)

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}

// ===========================
// INSTITUTE
// ===========================
object Institutes : Table("institute") {
    val id = uuid("id")
    val name = varchar("name", 255)
    val type = varchar("type", 50)
    val locationId = uuid("location_id").references(Locations.id)
    val universityId = uuid("university_id").references(Universities.id)
    val foundedYear = integer("founded_year")
    val scientificFieldId = uuid("scientific_field_id").references(ScientificFields.id)

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}

// ===========================
// RESEARCH PROGRAM
// ===========================
object ResearchPrograms : Table("research_program") {
    val id = uuid("id")
    val name = varchar("name", 255)
    val type = varchar("type", 50)
    val instituteId = uuid("institute_id").references(Institutes.id)
    val agencyId = uuid("agency_id").references(Agencies.id)

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}

// ===========================
// RESEARCHER
// ===========================
object Researchers : Table("researcher") {
    val id = uuid("id")
    val firstName = varchar("first_name", 100)
    val lastName = varchar("last_name", 100)
    val degree = varchar("degree", 50)
    val universityId = uuid("university_id").references(Universities.id)
    val instituteId = uuid("institute_id").references(Institutes.id)

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}

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

object Rooms : Table("room") {
    val id = uuid("id")
    val number = varchar("number", 50)
    val type = varchar("type", 50)
    val buildingId = uuid("building_id").references(Buildings.id)
    val area = double("area")

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}

object Equipment : Table("equipment") {
    val id = uuid("id")
    val name = varchar("name", 255)
    val type = varchar("type", 50)
    val roomId = uuid("room_id").references(Rooms.id)
    val purchaseYear = integer("purchase_year")
    val status = varchar("status", 50)

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}

// ===========================
// REAGENT
// ===========================
object Reagents : Table("reagent") {
    val id = uuid("id")
    val name = varchar("name", 255)
    val type = varchar("type", 50)
    val quantity = double("quantity")
    val unit = varchar("unit", 20)
    val roomId = uuid("room_id").references(Rooms.id)
    val expirationDate = date("expiration_date")

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}

// ===========================
// USER / AUTH
// ===========================
object Users : Table("user") {
    val id = uuid("id")
    val username = varchar("username", 50).uniqueIndex()
    val email = varchar("email", 100).uniqueIndex()
    val passwordHash = varchar("password_hash", 255)
    val researcherId = uuid("researcher_id").references(Researchers.id)

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}

object Roles : Table("role") {
    val id = uuid("id")
    val name = varchar("name", 50)
    val description = varchar("description", 255).nullable()

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}

object Permissions : Table("permission") {
    val id = uuid("id")
    val name = varchar("name", 100)
    val description = varchar("description", 255).nullable()

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}

object UserRoles : Table("user_role") {
    val userId = uuid("user_id").references(Users.id)
    val roleId = uuid("role_id").references(Roles.id)

    override val primaryKey = PrimaryKey(userId, roleId)
}

object RolePermissions : Table("role_permission") {
    val roleId = uuid("role_id").references(Roles.id)
    val permissionId = uuid("permission_id").references(Permissions.id)

    override val primaryKey = PrimaryKey(roleId, permissionId)
}

// ===========================
// RESEARCHER EXCHANGE
// ===========================
object ResearcherExchanges : Table("researcher_exchange") {
    val id = uuid("id")
    val researcherId = uuid("researcher_id").references(Researchers.id)
    val hostUniversityId = uuid("host_university_id").references(Universities.id)
    val hostInstituteId = uuid("host_institute_id").references(Institutes.id)
    val exchangeType = varchar("exchange_type", 50)
    val status = varchar("status", 30)
    val startDate = date("start_date")
    val endDate = date("end_date").nullable()

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}

// ===========================
// PUBLICATION
// ===========================
object Publications : Table("publication") {
    val id = uuid("id")
    val title = varchar("title", 500)
    val abstract = text("abstract").nullable()
    val publicationType = varchar("publication_type", 50)
    val journalOrPublisher = varchar("journal_or_publisher", 255).nullable()
    val doi = varchar("doi", 150).nullable().uniqueIndex()
    val publicationDate = date("publication_date").nullable()
    val scientificFieldId = uuid("scientific_field_id").references(ScientificFields.id)

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}

object PublicationAuthors : Table("publication_author") {
    val publicationId = uuid("publication_id").references(Publications.id)
    val researcherId = uuid("researcher_id").references(Researchers.id)
    val authorOrder = integer("author_order")
    val isCorrespondingAuthor = bool("is_corresponding_author").default(false)
    override val primaryKey = PrimaryKey(publicationId, researcherId)
}

// ===========================
// GRANT
// ===========================
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

object GrantParticipants : Table("grant_participant") {
    val grantId = uuid("grant_id").references(Grants.id)
    val researcherId = uuid("researcher_id").references(Researchers.id)
    val role = varchar("role", 30) // PI / CO_INVESTIGATOR / TEAM_MEMBER
    val participationPercent = decimal("participation_percent", 5, 2).nullable()
    override val primaryKey = PrimaryKey(grantId, researcherId)
}

object GrantPublications : Table("grant_publication") {
    val grantId = uuid("grant_id").references(Grants.id)
    val publicationId = uuid("publication_id").references(Publications.id)
    override val primaryKey = PrimaryKey(grantId, publicationId)
}
