package infrastructure.auth.model.result

import domain.auth.AuthEntity

data class FindAuthResult(
    val entity: AuthEntity?
)
