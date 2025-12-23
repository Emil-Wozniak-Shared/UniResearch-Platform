package infrastructure.auth.adapter

import domain.permission.Permission
import domain.permission.Permission.APPROVE_CHANGES
import domain.permission.Permission.AUDIT_LOGS
import domain.permission.Permission.EDIT_OWN
import domain.permission.Permission.GENERATE_REPORTS
import domain.permission.Permission.READ_ALL
import domain.permission.Permission.READ_OWN
import domain.permission.Permission.VIEW_PUBLIC_DATA
import domain.permission.Permission.WRITE_ALL
import domain.role.Role

object AuthValidator {
    private val rolePermissions: Map<Role, Set<Permission>> = mapOf(
        Role.IT_ADMIN to setOf(READ_ALL, WRITE_ALL, EDIT_OWN, GENERATE_REPORTS, APPROVE_CHANGES, AUDIT_LOGS),
        Role.MINISTRY to setOf(READ_ALL, GENERATE_REPORTS, APPROVE_CHANGES),
        Role.UNIVERSITY to setOf(READ_OWN, EDIT_OWN, GENERATE_REPORTS),
        Role.ACADEMY_INSTITUTE to setOf(READ_OWN, EDIT_OWN, GENERATE_REPORTS),
        Role.DEPARTMENT_UNIT to setOf(READ_OWN, EDIT_OWN),
        Role.PUBLIC_USER to setOf(VIEW_PUBLIC_DATA),
        Role.AUDITOR to setOf(READ_ALL, AUDIT_LOGS, GENERATE_REPORTS),
        Role.MODERATOR to setOf(READ_ALL, APPROVE_CHANGES, EDIT_OWN)
    )

    fun validate(role: Role, vararg permissions: Permission): Boolean =
        rolePermissions.getValue(role).containsAll(permissions.toSet())
}