package infrastructure.reagent.model.command

data class UpdateReagentCommand(
    val entity: domain.reagent.ReagentEntity
)
