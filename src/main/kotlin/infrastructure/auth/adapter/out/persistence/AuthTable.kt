package infrastructure.auth.adapter.out.persistence

import org.jetbrains.exposed.sql.Table

object Auths : Table("auth") {

    val id = uuid("id")
    val username = varchar("username", 255)
    val email = varchar("email", 255)
    val passwordHash = varchar("password_hash", 255)

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
