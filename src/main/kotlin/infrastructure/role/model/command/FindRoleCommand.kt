package infrastructure.role.model.command

import domain.role.RoleEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class FindRoleCommand(
    val id: java.util.UUID
)
