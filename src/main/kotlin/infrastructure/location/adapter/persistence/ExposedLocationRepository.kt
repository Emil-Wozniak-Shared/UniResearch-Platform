package infrastructure.location.adapter.persistence

import domain.location.LocationEntity
import infrastructure.location.adapter.persistence.exposed.Locations
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import common.Pageable
import java.util.UUID

class ExposedLocationRepository : LocationRepository {

    override fun findById(id: UUID): LocationEntity? =
        transaction {
            Locations
                .select(Locations.columns)
                .where { Locations.id eq id }
                .map(::toEntity)
                .singleOrNull()
        }

    override fun findAll(pageable: Pageable): List<LocationEntity> =
        transaction {
            Locations
                .select(Locations.columns)
                   .limit(pageable.size)
   .offset(pageable.page.toLong() * pageable.size)
                .map(::toEntity)
        }

    override fun create(entity: LocationEntity): LocationEntity =
        transaction {
            Locations.insert {
                it[name] = entity.name
                it[type] = entity.type
                it[parentLocationId] = entity.parentLocationId
            }
            entity
        }

    override fun update(entity: LocationEntity): LocationEntity =
        transaction {
            Locations.update({ Locations.id eq entity.id }) {
                it[name] = entity.name
                it[type] = entity.type
                it[parentLocationId] = entity.parentLocationId
            }
            entity
        }

    override fun delete(id: UUID): Boolean =
        transaction {
            Locations.deleteWhere { Locations.id eq id } > 0
        }

    private fun toEntity(row: ResultRow): LocationEntity =
        LocationEntity(
            id = row[Locations.id],
            name = row[Locations.name],
            type = row[Locations.type],
            parentLocationId = row[Locations.parentLocationId]
        )
}
