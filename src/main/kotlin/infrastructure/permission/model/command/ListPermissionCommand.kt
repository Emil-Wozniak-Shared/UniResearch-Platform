package infrastructure.permission.model.command

import common.Pageable
import kotlinx.serialization.Serializable

@Serializable
data class ListPermissionCommand(
    val pageable: Pageable
)
