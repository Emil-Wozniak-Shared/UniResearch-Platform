package common

import kotlinx.serialization.Serializable
import kotlin.math.ceil

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

@Serializable
data class Page<T>(
    val content: List<T>,
    val page: Int,
    val size: Int,
    val totalElements: Int,
    val totalPages: Int
)

fun <T> List<T>.toPage(
    page: Int,
    size: Int,
    totalElements: Int
): Page<T> {
    val totalPages = if (totalElements == 0) 0
    else ceil(totalElements.toDouble() / size).toInt()

    return Page(
        content = this,
        page = page,
        size = size,
        totalElements = totalElements,
        totalPages = totalPages
    )
}

