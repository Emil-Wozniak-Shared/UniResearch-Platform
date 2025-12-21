package pl.ejdev.common

data class Pageable(
    val page: Int = 0,
    val size: Int = 20,
    val sortBy: String? = null,
    val sortDir: SortDirection = SortDirection.ASC
)

enum class SortDirection {
    ASC, DESC
}
