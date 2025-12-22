package infrastructure.building.model.command

import common.Pageable

data class ListBuildingCommand(
    val pageable: Pageable
)
