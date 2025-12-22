package infrastructure.rolePermission.adapter.persistence.exposed

import infrastructure.permission.adapter.persistence.exposed.Permissions
import infrastructure.role.adapter.out.persistence.Roles
import org.jetbrains.exposed.sql.Table

object RolePermissions : Table("role_permission") {
    val roleId = uuid("role_id").references(Roles.id)
    val permissionId = uuid("permission_id").references(Permissions.id)
    override val primaryKey: PrimaryKey = PrimaryKey(roleId, permissionId)
}
