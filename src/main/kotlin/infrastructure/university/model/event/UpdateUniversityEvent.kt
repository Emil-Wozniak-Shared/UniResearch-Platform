package infrastructure.university.model.event

data class UpdateUniversityEvent(
    val entity: domain.university.UniversityEntity
)
