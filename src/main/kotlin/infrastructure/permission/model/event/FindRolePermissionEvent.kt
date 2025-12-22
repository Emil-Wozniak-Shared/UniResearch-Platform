package infrastructure.permission.model.event

import java.util.UUID

data class FindRolePermissionEvent(val roleId: UUID, val permissionId: UUID)
