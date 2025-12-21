package infrastructure.role.model.event

import domain.role.RoleEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class DeleteRoleEvent(
    val id: java.util.UUID
)
