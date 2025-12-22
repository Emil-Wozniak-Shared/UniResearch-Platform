package infrastructure.university.model.command

import common.Pageable

data class ListUniversityCommand(
    val pageable: Pageable
)
