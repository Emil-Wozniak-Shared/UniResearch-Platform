package infrastructure.role.model.command

import common.Pageable

data class ListRoleCommand(
    val pageable: Pageable
)
