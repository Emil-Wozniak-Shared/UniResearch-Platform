import infrastructure.agency.adapter.`in`.http.AgencyHttpAdapter
import infrastructure.agency.adapter.`in`.http.AgencyHttpHandler
import infrastructure.agency.port.`in`.http.AgencyHttpPort
import infrastructure.institution.adapter.http.InstitutionHttpAdapter
import infrastructure.institution.adapter.http.InstitutionHttpHandler
import infrastructure.institution.adapter.out.persistance.InstitutionPersistenceAdapter
import infrastructure.institution.port.`in`.http.InstitutionHttpPort
import infrastructure.institution.port.out.persistance.InstitutionPersistencePort
import infrastructure.university.adapter.`in`.http.UniversityHttpAdapter
import infrastructure.university.adapter.`in`.http.UniversityHttpHandler
import infrastructure.university.adapter.out.persistence.UniversityPersistenceAdapter
import infrastructure.university.port.`in`.http.UniversityHttpPort
import infrastructure.university.port.out.persistance.UniversityPersistencePort
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger
import pl.ejdev.infrastructure.agency.adapter.out.persistence.AgencyPersistenceAdapter
import pl.ejdev.infrastructure.agency.port.out.persistence.AgencyPersistencePort

fun Application.configureFrameworks() {
    install(Koin) {
        slf4jLogger()
        modules(module {
            single<Database> { database() }
            single<AgencyPersistencePort> { AgencyPersistenceAdapter(get()) }
            single<AgencyHttpPort> { AgencyHttpAdapter(get()) }
            single<AgencyHttpHandler> { AgencyHttpHandler(get()) }

            single<UniversityPersistencePort> { UniversityPersistenceAdapter(get()) }
            single<UniversityHttpPort> { UniversityHttpAdapter(get()) }
            single<UniversityHttpHandler> { UniversityHttpHandler(get()) }

            single<InstitutionPersistencePort> { InstitutionPersistenceAdapter(get()) }
            single<InstitutionHttpPort> { InstitutionHttpAdapter(get()) }
            single<InstitutionHttpHandler> { InstitutionHttpHandler(get()) }
        })
    }
}

private fun Application.database(): Database {
    val url = environment.config.property("database.url").getString()
    val user = environment.config.property("database.user").getString()
    val password = environment.config.property("database.password").getString()
    val driver = environment.config.property("database.driver").getString()
    return Database.connect(
        url = url,
        user = user,
        driver = driver,
        password = password,
    )
}
