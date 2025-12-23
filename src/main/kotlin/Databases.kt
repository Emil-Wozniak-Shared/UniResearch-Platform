import infrastructure.agency.adapter.persistence.exposed.Agencies
import infrastructure.building.adapter.persistence.exposed.Buildings
import infrastructure.equipment.adapter.persistence.exposed.Equipment
import infrastructure.grant.adapter.persistence.Grants
import infrastructure.grant.adapter.persistence.GrantParticipants
import infrastructure.grant.adapter.persistence.GrantPublications
import infrastructure.institution.adapter.out.persistance.Institutions
import infrastructure.location.adapter.persistence.exposed.Locations
import infrastructure.permission.adapter.out.persistence.Permissions
import infrastructure.publication.adapter.persistence.exposed.Publications
import infrastructure.publication.adapter.persistence.exposed.PublicationAuthors
import infrastructure.reagent.adapter.persistence.exposed.Reagents
import infrastructure.researcher.adapter.persistence.ResearchPrograms
import infrastructure.researcher.adapter.persistence.Researchers
import infrastructure.researcher.adapter.persistence.ResearcherExchanges
import infrastructure.role.adapter.out.persistence.Roles
import infrastructure.role.adapter.out.persistence.RolePermissions
import infrastructure.room.adapter.persistence.exposed.Rooms
import infrastructure.scientificField.adapter.persistence.exposed.ScientificFields
import infrastructure.university.adapter.out.persistence.exposed.Universities
import infrastructure.user.adapter.out.persistence.Users
import infrastructure.user.adapter.out.persistence.UserRoles
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.name
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.ktor.ext.inject
import java.io.File
import java.sql.Connection
import java.sql.DriverManager

fun Application.configureDatabases() {
    val db by inject<Database>()
    log.info("Create tables in Database: ${db.name}")
    transaction {
        db
    }
    transaction {
        SchemaUtils.create(
            Locations,
            Institutions,
            ScientificFields,
            Agencies,
            Universities,
            ResearchPrograms,
            Researchers,
            Buildings,
            Rooms,
            Equipment,
            Reagents,
            Users,
            Roles,
            Permissions,
            UserRoles,
            RolePermissions,
            ResearcherExchanges,
            Publications,
            PublicationAuthors,
            Grants,
            GrantParticipants,
            GrantPublications
        )

        populateTables(db)
    }
}

private fun Application.populateTables(db: Database) {
    val inserted = transaction {
        Users.selectAll().count() > 0
    }
    if (inserted) {
        return
    }
    val sqlFile = File(this::class.java.getResource("/dev-init.sql")!!.toURI())

    if (sqlFile.exists()) {
        val sqlStatements = sqlFile.readText()
            .split(";")   // split multiple statements
            .map { it.trim() }
            .filter { it.isNotEmpty() }

        transaction(db) {
            sqlStatements.forEach { exec(it) }
        }
        log.info("Executed dev-init.sql with ${sqlStatements.size} statements")
    } else {
        log.warn("SQL file not found: ${sqlFile.absolutePath}")
    }
}

fun Application.connectToPostgres(embedded: Boolean): Connection {
    Class.forName("org.postgresql.Driver")
    if (embedded) {
        log.info("Using embedded H2 database for testing; replace this flag to use postgres")
        return DriverManager.getConnection("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", "root", "")
    } else {
        val url = environment.config.property("postgres.url").getString()
        log.info("Connecting to postgres database at $url")
        val user = environment.config.property("postgres.user").getString()
        val password = environment.config.property("postgres.password").getString()

        return DriverManager.getConnection(url, user, password)
    }
}
