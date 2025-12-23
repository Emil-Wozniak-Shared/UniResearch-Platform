package infrastructure.user.model.event

import common.Pageable
import java.util.UUID

data class ListEagerUserRolesEvent(
    val userId: UUID,
    val pageable: Pageable
)