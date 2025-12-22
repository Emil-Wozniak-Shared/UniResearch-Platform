import infrastructure.agency.adapter.`in`.http.AgencyHttpAdapter
import infrastructure.agency.adapter.`in`.http.AgencyHttpHandler
import infrastructure.agency.port.`in`.http.AgencyHttpPort
import infrastructure.institution.adapter.http.InstitutionHttpAdapter
import infrastructure.institution.adapter.http.InstitutionHttpHandler
import infrastructure.institution.adapter.out.persistance.InstitutionPersistenceAdapter
import infrastructure.institution.port.`in`.http.InstitutionHttpPort
import infrastructure.institution.port.out.persistance.InstitutionPersistencePort
import infrastructure.permission.adapter.`in`.http.PermissionHttpAdapter
import infrastructure.permission.adapter.`in`.http.PermissionHttpHandler
import infrastructure.permission.adapter.`in`.http.RolePermissionHttpAdapter
import infrastructure.permission.adapter.`in`.http.RolePermissionHttpHandler
import infrastructure.permission.adapter.out.persistence.PermissionPersistenceAdapter
import infrastructure.permission.adapter.out.persistence.RolePermissionPersistenceAdapter
import infrastructure.permission.port.`in`.http.PermissionHttpPort
import infrastructure.permission.port.`in`.http.RolePermissionHttpPort
import infrastructure.permission.port.out.persistence.PermissionPersistencePort
import infrastructure.permission.port.out.persistence.RolePermissionPersistencePort
import infrastructure.role.adapter.`in`.http.RoleHttpAdapter
import infrastructure.role.adapter.`in`.http.RoleHttpHandler
import infrastructure.role.adapter.out.persistence.RolePersistenceAdapter
import infrastructure.role.port.`in`.http.RoleHttpPort
import infrastructure.role.port.out.persistence.RolePersistencePort
import infrastructure.university.adapter.`in`.http.UniversityHttpAdapter
import infrastructure.university.adapter.`in`.http.UniversityHttpHandler
import infrastructure.university.adapter.out.persistence.UniversityPersistenceAdapter
import infrastructure.university.port.`in`.http.UniversityHttpPort
import infrastructure.university.port.out.persistance.UniversityPersistencePort
import infrastructure.user.adapter.`in`.http.UserHttpAdapter
import infrastructure.user.adapter.`in`.http.UserHttpHandler
import infrastructure.user.adapter.`in`.http.UserRoleHttpAdapter
import infrastructure.user.adapter.`in`.http.UserRoleHttpHandler
import infrastructure.user.adapter.out.persistence.UserPersistenceAdapter
import infrastructure.user.adapter.out.persistence.UserRolePersistenceAdapter
import infrastructure.user.port.`in`.http.UserHttpPort
import infrastructure.user.port.`in`.http.UserRoleHttpPort
import infrastructure.user.port.out.persistence.UserPersistencePort
import infrastructure.user.port.out.persistence.UserRolePersistencePort
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

            single<UserPersistencePort> { UserPersistenceAdapter(get()) }
            single<UserHttpPort> { UserHttpAdapter(get()) }
            single<UserHttpHandler> { UserHttpHandler(get()) }

            single<RolePersistencePort> { RolePersistenceAdapter(get()) }
            single<RoleHttpPort> { RoleHttpAdapter(get()) }
            single<RoleHttpHandler> { RoleHttpHandler(get()) }

            single<UserRolePersistencePort> { UserRolePersistenceAdapter(get()) }
            single<UserRoleHttpPort> { UserRoleHttpAdapter(get()) }
            single<UserRoleHttpHandler> { UserRoleHttpHandler(get()) }

            single<PermissionPersistencePort> { PermissionPersistenceAdapter(get()) }
            single<PermissionHttpPort> { PermissionHttpAdapter(get()) }
            single<PermissionHttpHandler> { PermissionHttpHandler(get()) }

            single<RolePermissionPersistencePort> { RolePermissionPersistenceAdapter(get()) }
            single<RolePermissionHttpPort> { RolePermissionHttpAdapter(get()) }
            single<RolePermissionHttpHandler> { RolePermissionHttpHandler(get()) }
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
