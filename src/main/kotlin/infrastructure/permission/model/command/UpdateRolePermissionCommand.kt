package infrastructure.permission.model.command

import domain.role.RolePermissionEntity

data class UpdateRolePermissionCommand(val entity: RolePermissionEntity)