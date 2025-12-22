package infrastructure.university.model.command

data class CreateUniversityCommand(
    val entity: domain.university.UniversityEntity
)
