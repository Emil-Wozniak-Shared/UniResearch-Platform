package infrastructure.auth.model.result

import domain.auth.AuthEntity

data class CreateAuthResult(
    val entity: AuthEntity
)
