package domain.publication

import java.util.UUID
import java.time.LocalDate

data class PublicationEntity(
    val id: UUID,
    val title: String,
    val abstract: String?,
    val publicationType: String,
    val journalOrPublisher: String?,
    val doi: String?,
    val publicationDate: LocalDate?,
    val scientificFieldId: UUID
)
