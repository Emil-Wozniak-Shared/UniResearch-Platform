package infrastructure.user.model.command

import common.Pageable

data class ListUserCommand(
    val pageable: Pageable
)
