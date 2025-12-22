package infrastructure.user.model.event

import common.Pageable
import java.util.UUID

data class ListUserRolesEvent(val userId: UUID, val pageable: Pageable)