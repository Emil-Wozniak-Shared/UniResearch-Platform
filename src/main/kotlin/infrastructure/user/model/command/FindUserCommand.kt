package infrastructure.user.model.command

import java.util.UUID

data class FindUserCommand(
    val id: UUID
)
