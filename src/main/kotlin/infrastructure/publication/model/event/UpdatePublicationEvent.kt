package infrastructure.publication.model.event

data class UpdatePublicationEvent(
    val entity: domain.publication.PublicationEntity
)
