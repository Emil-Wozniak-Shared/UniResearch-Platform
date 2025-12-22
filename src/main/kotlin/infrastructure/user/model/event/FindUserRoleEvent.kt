package infrastructure.user.model.event

import java.util.UUID

data class FindUserRoleEvent(val userId: UUID, val roleId: UUID)
