package infrastructure.grant.model.result

import domain.grant.GrantEntity
import java.util.UUID

data class ListGrantResult(
    val entities: List<GrantEntity>
)
