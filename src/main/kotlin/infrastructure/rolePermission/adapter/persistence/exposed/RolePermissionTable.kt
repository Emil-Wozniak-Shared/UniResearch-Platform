package infrastructure.rolePermission.adapter.persistence.exposed

import infrastructure.permission.adapter.persistence.exposed.Permissions
import infrastructure.role.adapter.persistence.exposed.Roles
import org.jetbrains.exposed.sql.Table
import java.util.UUID

object RolePermissions : Table("role_permission") {
    val roleId = uuid("role_id").references(Roles.id)
    val permissionId = uuid("permission_id").references(Permissions.id)
    override val primaryKey: PrimaryKey = PrimaryKey(roleId, permissionId)
}
