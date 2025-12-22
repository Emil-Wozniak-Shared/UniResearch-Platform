package infrastructure.user.model.result

import kotlinx.serialization.Serializable

@Serializable
data class DeleteUserResult(
    val deleted: Boolean
)
