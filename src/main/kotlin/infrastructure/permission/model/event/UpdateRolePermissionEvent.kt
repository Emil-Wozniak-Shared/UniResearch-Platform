package infrastructure.permission.model.event

import domain.role.RolePermissionEntity

data class UpdateRolePermissionEvent(val entity: RolePermissionEntity)