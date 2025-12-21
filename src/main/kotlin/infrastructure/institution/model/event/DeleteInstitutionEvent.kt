package infrastructure.institution.model.event

import java.util.UUID
import pl.ejdev.common.Pageable
import domain.institution.InstitutionEntity

data class DeleteInstitutionEvent(
    val id: java.util.UUID
)
