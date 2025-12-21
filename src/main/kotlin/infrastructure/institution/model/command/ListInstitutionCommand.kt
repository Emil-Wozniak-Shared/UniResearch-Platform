package infrastructure.institution.model.command

import java.util.UUID
import pl.ejdev.common.Pageable
import domain.institution.InstitutionEntity

data class ListInstitutionCommand(
    val pageable: pl.ejdev.common.Pageable
)
