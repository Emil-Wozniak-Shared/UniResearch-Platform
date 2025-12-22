package infrastructure.user.model.command

import java.util.UUID

data class DeleteUserRoleCommand(val userId: UUID, val roleId: UUID)