package infrastructure.agency.model.event

data class UpdateAgencyEvent(
    val entity: domain.agency.AgencyEntity
)
