package infrastructure.auth.adapter.persistence

import domain.auth.AuthEntity
import infrastructure.auth.adapter.persistence.exposed.Auths
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import common.Pageable
import java.util.*

class ExposedAuthRepository : AuthRepository {

    override fun findById(id: UUID): AuthEntity? =
        transaction {
            Auths
                .select(Auths.columns)
                .where { Auths.id eq id }
                .map(::toEntity)
                .singleOrNull()
        }

    override fun findAll(pageable: Pageable): List<AuthEntity> =
        transaction {
            Auths
                .select(Auths.columns)
                .limit(pageable.size)
                .offset(pageable.page.toLong() * pageable.size)
                .map(::toEntity)
        }

    override fun create(entity: AuthEntity): AuthEntity =
        transaction {
            Auths.insert {
                it[id] = entity.id
                it[username] = entity.username
                it[email] = entity.email
                it[passwordHash] = entity.passwordHash
            }
            entity
        }

    override fun update(entity: AuthEntity): AuthEntity =
        transaction {
            Auths.update({ Auths.id eq entity.id }) {
                it[id] = entity.id
            }
            entity
        }

    override fun delete(id: UUID): Boolean =
        transaction {
            Auths.deleteWhere { Auths.id eq id } > 0
        }

    private fun toEntity(row: ResultRow): AuthEntity =
        AuthEntity(
            id = row[Auths.id],
            username = row[Auths.username],
            email = row[Auths.email],
            passwordHash = row[Auths.passwordHash],
        )
}
