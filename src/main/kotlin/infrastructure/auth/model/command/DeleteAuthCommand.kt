package infrastructure.auth.model.command

import java.util.UUID
import pl.ejdev.common.Pageable
import domain.auth.AuthEntity

data class DeleteAuthCommand(
    val id: java.util.UUID
)
