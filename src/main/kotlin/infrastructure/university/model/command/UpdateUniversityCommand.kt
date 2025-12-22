package infrastructure.university.model.command

data class UpdateUniversityCommand(
    val entity: domain.university.UniversityEntity
)
