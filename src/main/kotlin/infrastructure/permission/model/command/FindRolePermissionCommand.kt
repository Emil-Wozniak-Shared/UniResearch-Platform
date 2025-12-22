package infrastructure.permission.model.command

import java.util.UUID

data class FindRolePermissionCommand(val roleId: UUID, val permissionId: UUID)
