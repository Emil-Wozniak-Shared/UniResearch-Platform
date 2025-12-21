package infrastructure.userRole.adapter.persistence.exposed

import infrastructure.role.adapter.persistence.exposed.Roles
import infrastructure.user.adapter.persistence.exposed.Users
import org.jetbrains.exposed.sql.Table
import java.util.UUID

object UserRoles : Table("user_role") {
    val userId = uuid("user_id").references(Users.id)
    val roleId = uuid("role_id").references(Roles.id)
    override val primaryKey: PrimaryKey = PrimaryKey(userId, roleId)
}
