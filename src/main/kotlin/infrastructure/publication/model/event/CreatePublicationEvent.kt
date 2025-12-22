package infrastructure.publication.model.event

data class CreatePublicationEvent(
    val entity: domain.publication.PublicationEntity
)
