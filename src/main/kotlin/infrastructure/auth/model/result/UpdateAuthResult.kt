package infrastructure.auth.model.result

import domain.auth.AuthEntity

data class UpdateAuthResult(
    val entity: AuthEntity
)
