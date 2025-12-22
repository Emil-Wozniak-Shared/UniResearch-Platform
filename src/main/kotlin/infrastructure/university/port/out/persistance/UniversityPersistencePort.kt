package infrastructure.university.port.out.persistance

import infrastructure.university.model.event.*
import infrastructure.university.model.result.*

interface UniversityPersistencePort {
    suspend fun find(event: FindUniversityEvent): FindUniversityResult
    suspend fun list(event: ListUniversityEvent): ListUniversityResult
    suspend fun create(event: CreateUniversityEvent): CreateUniversityResult
    suspend fun update(event: UpdateUniversityEvent): UpdateUniversityResult
    suspend fun delete(event: DeleteUniversityEvent): DeleteUniversityResult
}
