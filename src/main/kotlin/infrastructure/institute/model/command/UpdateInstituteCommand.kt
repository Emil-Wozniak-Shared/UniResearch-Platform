package infrastructure.institute.model.command

import domain.institute.InstituteEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class UpdateInstituteCommand(
    val entity: domain.institute.InstituteEntity
)
