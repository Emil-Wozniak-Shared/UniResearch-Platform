package infrastructure.university.adapter.`in`.http

import infrastructure.university.model.event.*
import infrastructure.university.port.`in`.http.UniversityHttpPort
import infrastructure.university.port.out.persistance.UniversityPersistencePort

class UniversityHttpAdapter(
    private val persistence: UniversityPersistencePort
) : UniversityHttpPort {

    override suspend fun find(event: FindUniversityEvent) = persistence.find(event)
    override suspend fun list(event: ListUniversityEvent) = persistence.list(event)
    override suspend fun create(event: CreateUniversityEvent) = persistence.create(event)
    override suspend fun update(event: UpdateUniversityEvent) = persistence.update(event)
    override suspend fun delete(event: DeleteUniversityEvent) = persistence.delete(event)
}
