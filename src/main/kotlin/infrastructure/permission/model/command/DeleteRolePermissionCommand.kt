package infrastructure.permission.model.command

import java.util.UUID

data class DeleteRolePermissionCommand(val roleId: UUID, val permissionId: UUID)