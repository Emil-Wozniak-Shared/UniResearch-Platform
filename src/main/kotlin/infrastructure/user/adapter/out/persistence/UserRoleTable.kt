package infrastructure.user.adapter.out.persistence

import infrastructure.role.adapter.out.persistence.Roles
import org.jetbrains.exposed.sql.Table

object UserRoles : Table("user_role") {
    val userId = uuid("user_id").references(Users.id)
    val roleId = uuid("role_id").references(Roles.id)
    override val primaryKey: PrimaryKey = PrimaryKey(userId, roleId)
}
