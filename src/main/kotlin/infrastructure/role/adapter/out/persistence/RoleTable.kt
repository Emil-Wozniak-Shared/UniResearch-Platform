package infrastructure.role.adapter.out.persistence

import org.jetbrains.exposed.sql.Table

object Roles : Table("role") {
    val id = uuid("id")
    val name = varchar("name", 50)
    val description = varchar("description", 255).nullable()
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
