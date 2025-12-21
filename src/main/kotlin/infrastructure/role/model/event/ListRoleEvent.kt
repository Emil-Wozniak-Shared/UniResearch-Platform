package infrastructure.role.model.event

import domain.role.RoleEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class ListRoleEvent(
    val pageable: pl.ejdev.common.Pageable
)
