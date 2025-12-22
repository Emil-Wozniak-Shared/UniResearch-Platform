package infrastructure.publication.model.command

data class UpdatePublicationCommand(
    val entity: domain.publication.PublicationEntity
)
