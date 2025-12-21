package infrastructure.institution.model.command

import java.util.UUID
import pl.ejdev.common.Pageable
import domain.institution.InstitutionEntity

data class UpdateInstitutionCommand(
    val entity: domain.institution.InstitutionEntity
)
