package infrastructure.institute.model.result

import domain.institute.InstituteEntity
import java.util.UUID

data class ListInstituteResult(
    val entities: List<InstituteEntity>
)
