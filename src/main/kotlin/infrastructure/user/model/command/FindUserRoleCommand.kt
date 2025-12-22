package infrastructure.user.model.command

import java.util.UUID

data class FindUserRoleCommand(val userId: UUID, val roleId: UUID)
