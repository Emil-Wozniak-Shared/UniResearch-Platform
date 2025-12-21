package infrastructure.institute.model.result

import domain.institute.InstituteEntity
import java.util.UUID

data class DeleteInstituteResult(
    val entity: InstituteEntity?
)
