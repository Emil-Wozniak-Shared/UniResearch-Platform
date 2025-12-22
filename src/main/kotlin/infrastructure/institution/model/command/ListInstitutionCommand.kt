package infrastructure.institution.model.command

import common.Pageable

data class ListInstitutionCommand(
    val pageable: Pageable
)
