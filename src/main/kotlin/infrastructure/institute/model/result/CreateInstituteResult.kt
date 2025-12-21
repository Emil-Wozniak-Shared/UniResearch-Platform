package infrastructure.institute.model.result

import domain.institute.InstituteEntity
import java.util.UUID

data class CreateInstituteResult(
    val entity: domain.institute.InstituteEntity
)
