package infrastructure.reagent.model.command

data class CreateReagentCommand(
    val entity: domain.reagent.ReagentEntity
)
