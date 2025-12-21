package infrastructure.institute.model.event

import domain.institute.InstituteEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class ListInstituteEvent(
    val pageable: pl.ejdev.common.Pageable
)
