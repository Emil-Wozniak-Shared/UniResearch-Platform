package infrastructure.permission.model.event

import java.util.UUID

data class DeleteRolePermissionEvent(val roleId: UUID, val permissionId: UUID)