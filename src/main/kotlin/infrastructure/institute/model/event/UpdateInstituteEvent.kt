package infrastructure.institute.model.event

import domain.institute.InstituteEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class UpdateInstituteEvent(
    val entity: domain.institute.InstituteEntity
)
