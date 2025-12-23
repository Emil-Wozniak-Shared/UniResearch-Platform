package infrastructure.user.model.event

sealed class FindByUserEvent

data class FindByUsername(val username: String) : FindByUserEvent()
