package infrastructure.auth.model.result

import domain.auth.AuthEntity

data class ListAuthResult(
    val items: List<AuthEntity>
)
