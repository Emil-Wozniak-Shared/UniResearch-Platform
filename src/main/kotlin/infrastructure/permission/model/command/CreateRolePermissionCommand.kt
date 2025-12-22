package infrastructure.permission.model.command

import domain.role.RolePermissionEntity

data class CreateRolePermissionCommand(val entity: RolePermissionEntity)