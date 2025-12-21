package infrastructure.institute.model.result

import domain.institute.InstituteEntity
import java.util.UUID

data class FindInstituteResult(
    val entity: InstituteEntity?
)
