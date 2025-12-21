package infrastructure.institution.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table

object Institutions : Table("institution") {

    val id = uuid("id").autoIncrement()

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
