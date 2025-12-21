package pl.ejdev.common

import kotlinx.serialization.Serializable

@Serializable
data class Pageable(
    val page: Int = 0,
    val size: Int = 20,
    val sortBy: String? = null,
    val sortDir: SortDirection = SortDirection.ASC
)

@Serializable
enum class SortDirection {
    ASC, DESC
}
