package infrastructure.permission.model.event

import common.Pageable
import java.util.UUID

data class ListRolePermissionsEvent(val roleId: UUID, val pageable: Pageable)