package infrastructure.publication.model.command

data class CreatePublicationCommand(
    val entity: domain.publication.PublicationEntity
)
