package infrastructure.role.model.event

import domain.role.RoleEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class CreateRoleEvent(
    val entity: domain.role.RoleEntity
)
