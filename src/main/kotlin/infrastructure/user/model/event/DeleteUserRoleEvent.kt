package infrastructure.user.model.event

import java.util.UUID

data class DeleteUserRoleEvent(val userId: UUID, val roleId: UUID)