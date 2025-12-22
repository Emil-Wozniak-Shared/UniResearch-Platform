package pl.ejdev

import infrastructure.agency.adapter.persistence.exposed.Agencies
import infrastructure.building.adapter.persistence.exposed.Buildings
import infrastructure.equipment.adapter.persistence.exposed.Equipment
import infrastructure.grant.adapter.persistence.exposed.Grants
import infrastructure.grantParticipant.adapter.persistence.exposed.GrantParticipants
import infrastructure.grantPublication.adapter.persistence.exposed.GrantPublications
import infrastructure.institute.adapter.persistence.exposed.Institutes
import infrastructure.location.adapter.persistence.exposed.Locations
import infrastructure.permission.adapter.persistence.exposed.Permissions
import infrastructure.publication.adapter.persistence.exposed.Publications
import infrastructure.publicationAuthor.adapter.persistence.exposed.PublicationAuthors
import infrastructure.reagent.adapter.persistence.exposed.Reagents
import infrastructure.researchProgram.adapter.persistence.exposed.ResearchPrograms
import infrastructure.researcher.adapter.persistence.exposed.Researchers
import infrastructure.researcherExchange.adapter.persistence.exposed.ResearcherExchanges
import infrastructure.role.adapter.persistence.exposed.Roles
import infrastructure.rolePermission.adapter.persistence.exposed.RolePermissions
import infrastructure.room.adapter.persistence.exposed.Rooms
import infrastructure.scientificField.adapter.persistence.exposed.ScientificFields
import infrastructure.university.adapter.out.persistence.exposed.Universities
import infrastructure.user.adapter.persistence.exposed.Users
import infrastructure.userRole.adapter.persistence.exposed.UserRoles
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.Connection
import java.sql.DriverManager

fun Application.configureDatabases() {
    transaction {
        SchemaUtils.create(
            Locations,
            ScientificFields,
            Agencies,
            Universities,
            Institutes,
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
