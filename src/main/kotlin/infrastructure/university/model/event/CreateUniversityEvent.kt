package infrastructure.university.model.event

data class CreateUniversityEvent(
    val entity: domain.university.UniversityEntity
)
