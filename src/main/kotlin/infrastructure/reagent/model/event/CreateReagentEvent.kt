package infrastructure.reagent.model.event

data class CreateReagentEvent(
    val entity: domain.reagent.ReagentEntity
)
