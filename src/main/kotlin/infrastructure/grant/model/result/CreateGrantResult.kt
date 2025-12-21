package infrastructure.grant.model.result

import domain.grant.GrantEntity
import java.util.UUID

data class CreateGrantResult(
    val entity: domain.grant.GrantEntity
)
