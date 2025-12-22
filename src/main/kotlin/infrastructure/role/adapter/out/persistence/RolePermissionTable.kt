package infrastructure.role.adapter.out.persistence

import infrastructure.permission.adapter.out.persistence.Permissions
import org.jetbrains.exposed.sql.Table

object RolePermissions : Table("role_permission") {
    val roleId = uuid("role_id").references(Roles.id)
    val permissionId = uuid("permission_id").references(Permissions.id)
    override val primaryKey: PrimaryKey = PrimaryKey(roleId, permissionId)
}
