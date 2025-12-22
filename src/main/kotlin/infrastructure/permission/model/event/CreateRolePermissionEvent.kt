package infrastructure.permission.model.event

import domain.role.RolePermissionEntity

data class CreateRolePermissionEvent(val entity: RolePermissionEntity)