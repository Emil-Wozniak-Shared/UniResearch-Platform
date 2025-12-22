package infrastructure.institution.model.command

data class CreateInstitutionCommand(
    val entity: domain.institution.InstitutionEntity
)
