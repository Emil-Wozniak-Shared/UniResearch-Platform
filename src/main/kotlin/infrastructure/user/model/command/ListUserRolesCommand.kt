package infrastructure.user.model.command

import common.Pageable
import java.util.UUID

data class ListUserRolesCommand(val userId: UUID, val pageable: Pageable)