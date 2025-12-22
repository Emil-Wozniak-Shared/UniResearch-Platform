package infrastructure.permission.model.command

import common.Pageable
import java.util.UUID

data class ListRolePermissionsCommand(val roleId: UUID, val pageable: Pageable)