#!/bin/bash

BASE_PATH="src/main/kotlin/infrastructure"

declare -A TABLES

# =========================== LOCATION ===========================
TABLES["location"]='package infrastructure.location.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.date
import java.util.UUID

object Locations : Table("location") {
    val id = uuid("id").autoIncrement().autoIncrement()
    val name = varchar("name", 100)
    val type = varchar("type", 50)
    val parentLocationId = uuid("parent_location_id").references(Locations.id)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}'

# =========================== SCIENTIFIC FIELD ===========================
TABLES["scientificField"]='package infrastructure.scientificField.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object ScientificFields : Table("scientific_field") {
    val id = uuid("id").autoIncrement()
    val name = varchar("name", 100)
    val description = varchar("description", 255).nullable()
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}'

# =========================== AGENCY ===========================
TABLES["agency"]='package infrastructure.agency.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Agencies : Table("agency") {
    val id = uuid("id").autoIncrement()
    val name = varchar("name", 255)
    val type = varchar("type", 50)
    val activity = varchar("activity", 255)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}'

# =========================== UNIVERSITY ===========================
TABLES["university"]='package infrastructure.university.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Universities : Table("university") {
    val id = uuid("id").autoIncrement().autoIncrement()
    val name = varchar("name", 255)
    val type = varchar("type", 50)
    val locationId = uuid("location_id").references(Locations.id)
    val foundedYear = integer("founded_year")
    val scientificFieldId = uuid("scientific_field_id").references(ScientificFields.id)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}'

# =========================== INSTITUTE ===========================
TABLES["institute"]='package infrastructure.institute.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Institutes : Table("institute") {
    val id = uuid("id").autoIncrement()
    val name = varchar("name", 255)
    val type = varchar("type", 50)
    val locationId = uuid("location_id").references(Locations.id)
    val universityId = uuid("university_id").references(Universities.id)
    val foundedYear = integer("founded_year")
    val scientificFieldId = uuid("scientific_field_id").references(ScientificFields.id)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}'

# =========================== RESEARCH PROGRAM ===========================
TABLES["researchProgram"]='package infrastructure.researchProgram.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object ResearchPrograms : Table("research_program") {
    val id = uuid("id").autoIncrement()
    val name = varchar("name", 255)
    val type = varchar("type", 50)
    val instituteId = uuid("institute_id").references(Institutes.id)
    val agencyId = uuid("agency_id").references(Agencies.id)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}'

# =========================== RESEARCHER ===========================
TABLES["researcher"]='package infrastructure.researcher.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Researchers : Table("researcher") {
    val id = uuid("id").autoIncrement()
    val firstName = varchar("first_name", 100)
    val lastName = varchar("last_name", 100)
    val degree = varchar("degree", 50)
    val universityId = uuid("university_id").references(Universities.id)
    val instituteId = uuid("institute_id").references(Institutes.id)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}'

# =========================== BUILDING ===========================
TABLES["building"]='package infrastructure.building.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Buildings : Table("building") {
    val id = uuid("id").autoIncrement()
    val name = varchar("name", 255)
    val address = varchar("address", 255)
    val locationId = uuid("location_id").references(Locations.id)
    val universityId = uuid("university_id").references(Universities.id)
    val instituteId = uuid("institute_id").references(Institutes.id)
    val area = double("area")
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}'

# =========================== ROOM ===========================
TABLES["room"]='package infrastructure.room.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Rooms : Table("room") {
    val id = uuid("id").autoIncrement()
    val number = varchar("number", 50)
    val type = varchar("type", 50)
    val buildingId = uuid("building_id").references(Buildings.id)
    val area = double("area")
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}'

# =========================== EQUIPMENT ===========================
TABLES["equipment"]='package infrastructure.equipment.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Equipment : Table("equipment") {
    val id = uuid("id").autoIncrement()
    val name = varchar("name", 255)
    val type = varchar("type", 50)
    val roomId = uuid("room_id").references(Rooms.id)
    val purchaseYear = integer("purchase_year")
    val status = varchar("status", 50)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}'

# =========================== REAGENT ===========================
TABLES["reagent"]='package infrastructure.reagent.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.date
import java.util.UUID

object Reagents : Table("reagent") {
    val id = uuid("id").autoIncrement()
    val name = varchar("name", 255)
    val type = varchar("type", 50)
    val quantity = double("quantity")
    val unit = varchar("unit", 20)
    val roomId = uuid("room_id").references(Rooms.id)
    val expirationDate = date("expiration_date")
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}'

# =========================== USER ===========================
TABLES["user"]='package infrastructure.user.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Users : Table("user") {
    val id = uuid("id").autoIncrement()
    val username = varchar("username", 50).uniqueIndex()
    val email = varchar("email", 100).uniqueIndex()
    val passwordHash = varchar("password_hash", 255)
    val researcherId = uuid("researcher_id").references(Researchers.id)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}'

# =========================== ROLE ===========================
TABLES["role"]='package infrastructure.role.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Roles : Table("role") {
    val id = uuid("id").autoIncrement()
    val name = varchar("name", 50)
    val description = varchar("description", 255).nullable()
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}'

# =========================== PERMISSION ===========================
TABLES["permission"]='package infrastructure.permission.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object Permissions : Table("permission") {
    val id = uuid("id").autoIncrement()
    val name = varchar("name", 100)
    val description = varchar("description", 255).nullable()
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}'

# =========================== USER ROLE ===========================
TABLES["userRole"]='package infrastructure.userRole.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object UserRoles : Table("user_role") {
    val userId = uuid("user_id").references(Users.id)
    val roleId = uuid("role_id").references(Roles.id)
    override val primaryKey: PrimaryKey = PrimaryKey(userId, roleId)
}'

# =========================== ROLE PERMISSION ===========================
TABLES["rolePermission"]='package infrastructure.rolePermission.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object RolePermissions : Table("role_permission") {
    val roleId = uuid("role_id").references(Roles.id)
    val permissionId = uuid("permission_id").references(Permissions.id)
    override val primaryKey: PrimaryKey = PrimaryKey(roleId, permissionId)
}'

# =========================== RESEARCHER EXCHANGE ===========================
TABLES["researcherExchange"]='package infrastructure.researcherExchange.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.date
import java.util.UUID

object ResearcherExchanges : Table("researcher_exchange") {
    val id = uuid("id").autoIncrement()
    val researcherId = uuid("researcher_id").references(Researchers.id)
    val hostUniversityId = uuid("host_university_id").references(Universities.id)
    val hostInstituteId = uuid("host_institute_id").references(Institutes.id)
    val exchangeType = varchar("exchange_type", 50)
    val status = varchar("status", 30)
    val startDate = date("start_date")
    val endDate = date("end_date").nullable()
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}'

# =========================== PUBLICATION ===========================
TABLES["publication"]='package infrastructure.publication.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.date
import java.util.UUID

object Publications : Table("publication") {
    val id = uuid("id").autoIncrement()
    val title = varchar("title", 500)
    val abstract = text("abstract").nullable()
    val publicationType = varchar("publication_type", 50)
    val journalOrPublisher = varchar("journal_or_publisher", 255).nullable()
    val doi = varchar("doi", 150).nullable().uniqueIndex()
    val publicationDate = date("publication_date").nullable()
    val scientificFieldId = uuid("scientific_field_id").references(ScientificFields.id)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}'

# =========================== PUBLICATION AUTHOR ===========================
TABLES["publicationAuthor"]='package infrastructure.publicationAuthor.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object PublicationAuthors : Table("publication_author") {
    val publicationId = uuid("publication_id").references(Publications.id)
    val researcherId = uuid("researcher_id").references(Researchers.id)
    val authorOrder = integer("author_order")
    val isCorrespondingAuthor = bool("is_corresponding_author").default(false)
    override val primaryKey: PrimaryKey = PrimaryKey(publicationId, researcherId)
}'

# =========================== GRANT ===========================
TABLES["grant"]='package infrastructure.grant.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.kotlin.datetime.date
import java.util.UUID

object Grants : Table("grant") {
    val id = uuid("id").autoIncrement()
    val title = varchar("title", 500)
    val description = text("description").nullable()
    val grantNumber = varchar("grant_number", 100).uniqueIndex()
    val startDate = date("start_date")
    val endDate = date("end_date").nullable()
    val totalAmount = decimal("total_amount", 14, 2)
    val currency = varchar("currency", 3)
    val agencyId = uuid("agency_id").references(Agencies.id)
    val scientificFieldId = uuid("scientific_field_id").references(ScientificFields.id)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}'

# =========================== GRANT PARTICIPANT ===========================
TABLES["grantParticipant"]='package infrastructure.grantParticipant.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object GrantParticipants : Table("grant_participant") {
    val grantId = uuid("grant_id").references(Grants.id)
    val researcherId = uuid("researcher_id").references(Researchers.id)
    val role = varchar("role", 30)
    val participationPercent = decimal("participation_percent", 5, 2).nullable()
    override val primaryKey: PrimaryKey = PrimaryKey(grantId, researcherId)
}'

# =========================== GRANT PUBLICATION ===========================
TABLES["grantPublication"]='package infrastructure.grantPublication.adapter.persistence.exposed

import org.jetbrains.exposed.sql.Table
import java.util.UUID

object GrantPublications : Table("grant_publication") {
    val grantId = uuid("grant_id").references(Grants.id)
    val publicationId = uuid("publication_id").references(Publications.id)
    override val primaryKey: PrimaryKey = PrimaryKey(grantId, publicationId)
}'

# =========================== CREATE FILES ===========================
for DOMAIN in "${!TABLES[@]}"; do
    DIR="$BASE_PATH/$DOMAIN/adapter/persistence/exposed"
    mkdir -p "$DIR"
    FILE="$DIR/$(tr '[:lower:]' '[:upper:]' <<< ${DOMAIN:0:1})${DOMAIN:1}Table.kt"
    echo "${TABLES[$DOMAIN]}" > "$FILE"
    echo "Written $DOMAIN tables to $FILE"
done
