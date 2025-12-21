package pl.ejdev

import pl.ejdev.infrastructure.agency.adapter.`in`.http.AgencyHttpAdapter
import pl.ejdev.infrastructure.agency.adapter.out.persistence.AgencyPersistenceAdapter
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger
import pl.ejdev.infrastructure.agency.adapter.`in`.http.AgencyHttpHandler
import pl.ejdev.infrastructure.agency.port.`in`.http.AgencyHttpPort
import pl.ejdev.infrastructure.agency.port.out.persistence.AgencyPersistencePort

fun Application.configureFrameworks() {
    install(Koin) {
        slf4jLogger()
        modules(module {
            single<Database> { database() }
            single<AgencyPersistencePort> { AgencyPersistenceAdapter(get()) }
            single<AgencyHttpPort> { AgencyHttpAdapter(get()) }
            single<AgencyHttpHandler> { AgencyHttpHandler(get()) }
        })
    }
}

private fun database(): Database = Database.connect(
    url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1",
    user = "root",
    driver = "org.h2.Driver",
    password = "",
)
