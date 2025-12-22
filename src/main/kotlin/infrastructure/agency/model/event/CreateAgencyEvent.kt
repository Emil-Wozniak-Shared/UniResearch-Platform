package infrastructure.agency.model.event

data class CreateAgencyEvent(
    val entity: domain.agency.AgencyEntity
)
