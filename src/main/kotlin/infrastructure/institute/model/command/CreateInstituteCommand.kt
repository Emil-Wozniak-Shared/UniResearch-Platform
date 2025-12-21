package infrastructure.institute.model.command

import domain.institute.InstituteEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class CreateInstituteCommand(
    val entity: domain.institute.InstituteEntity
)
