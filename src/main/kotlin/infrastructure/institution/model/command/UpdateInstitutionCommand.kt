package infrastructure.institution.model.command

data class UpdateInstitutionCommand(
    val entity: domain.institution.InstitutionEntity
)
