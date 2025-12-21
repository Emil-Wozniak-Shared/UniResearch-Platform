package infrastructure.institute.model.command

import domain.institute.InstituteEntity
import pl.ejdev.common.Pageable
import java.util.UUID

data class ListInstituteCommand(
    val pageable: pl.ejdev.common.Pageable
)
