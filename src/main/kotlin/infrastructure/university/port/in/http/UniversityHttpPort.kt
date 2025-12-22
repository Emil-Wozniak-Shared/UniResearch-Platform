package infrastructure.university.port.`in`.http

import infrastructure.university.model.event.CreateUniversityEvent
import infrastructure.university.model.event.DeleteUniversityEvent
import infrastructure.university.model.event.FindUniversityEvent
import infrastructure.university.model.event.ListUniversityEvent
import infrastructure.university.model.event.UpdateUniversityEvent
import infrastructure.university.model.result.CreateUniversityResult
import infrastructure.university.model.result.DeleteUniversityResult
import infrastructure.university.model.result.FindUniversityResult
import infrastructure.university.model.result.ListUniversityResult
import infrastructure.university.model.result.UpdateUniversityResult

interface UniversityHttpPort {
    suspend fun find(event: FindUniversityEvent): FindUniversityResult
    suspend fun list(event: ListUniversityEvent): ListUniversityResult
    suspend fun create(event: CreateUniversityEvent): CreateUniversityResult
    suspend fun update(event: UpdateUniversityEvent): UpdateUniversityResult
    suspend fun delete(event: DeleteUniversityEvent): DeleteUniversityResult
}
