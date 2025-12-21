#!/bin/bash

BASE="."
DOMAINS=(location scientificField agency university institute researchProgram researcher building room equipment reagent user role permission researcherExchange publication grant)
ACTIONS=(Find List Create Update Delete)

echo "Creating project structure in $BASE..."

# -------------------------
# Create domain directories and entities based on Exposed tables
# -------------------------
for DOMAIN in "${DOMAINS[@]}"; do
  DOMAIN_DIR="$BASE/domain/$DOMAIN"
  mkdir -p "$DOMAIN_DIR"
  DOMAIN_CAP="$(tr '[:lower:]' '[:upper:]' <<< ${DOMAIN:0:1})${DOMAIN:1}"
  ENTITY_FILE="$DOMAIN_DIR/${DOMAIN_CAP}Entity.kt"

  case "$DOMAIN" in
    location)
      cat > "$ENTITY_FILE" <<EOL
package domain.$DOMAIN

import java.util.UUID

data class ${DOMAIN_CAP}Entity(
    val id: UUID,
    val name: String,
    val type: String,
    val parentLocationId: UUID
)
EOL
      ;;
    scientificField)
      cat > "$ENTITY_FILE" <<EOL
package domain.$DOMAIN

import java.util.UUID

data class ${DOMAIN_CAP}Entity(
    val id: UUID,
    val name: String,
    val description: String?
)
EOL
      ;;
    agency)
      cat > "$ENTITY_FILE" <<EOL
package domain.$DOMAIN

import java.util.UUID

data class ${DOMAIN_CAP}Entity(
    val id: UUID,
    val name: String,
    val type: String,
    val activity: String
)
EOL
      ;;
    university)
      cat > "$ENTITY_FILE" <<EOL
package domain.$DOMAIN

import java.util.UUID

data class ${DOMAIN_CAP}Entity(
    val id: UUID,
    val name: String,
    val type: String,
    val locationId: UUID,
    val foundedYear: Int,
    val scientificFieldId: UUID
)
EOL
      ;;
    institute)
      cat > "$ENTITY_FILE" <<EOL
package domain.$DOMAIN

import java.util.UUID

data class ${DOMAIN_CAP}Entity(
    val id: UUID,
    val name: String,
    val type: String,
    val locationId: UUID,
    val universityId: UUID,
    val foundedYear: Int,
    val scientificFieldId: UUID
)
EOL
      ;;
    researchProgram)
      cat > "$ENTITY_FILE" <<EOL
package domain.$DOMAIN

import java.util.UUID

data class ${DOMAIN_CAP}Entity(
    val id: UUID,
    val name: String,
    val type: String,
    val instituteId: UUID,
    val agencyId: UUID
)
EOL
      ;;
    researcher)
      cat > "$ENTITY_FILE" <<EOL
package domain.$DOMAIN

import java.util.UUID

data class ${DOMAIN_CAP}Entity(
    val id: UUID,
    val firstName: String,
    val lastName: String,
    val degree: String,
    val universityId: UUID,
    val instituteId: UUID
)
EOL
      ;;
    building)
      cat > "$ENTITY_FILE" <<EOL
package domain.$DOMAIN

import java.util.UUID

data class ${DOMAIN_CAP}Entity(
    val id: UUID,
    val name: String,
    val address: String,
    val locationId: UUID,
    val universityId: UUID,
    val instituteId: UUID,
    val area: Double
)
EOL
      ;;
    room)
      cat > "$ENTITY_FILE" <<EOL
package domain.$DOMAIN

import java.util.UUID

data class ${DOMAIN_CAP}Entity(
    val id: UUID,
    val number: String,
    val type: String,
    val buildingId: UUID,
    val area: Double
)
EOL
      ;;
    equipment)
      cat > "$ENTITY_FILE" <<EOL
package domain.$DOMAIN

import java.util.UUID

data class ${DOMAIN_CAP}Entity(
    val id: UUID,
    val name: String,
    val type: String,
    val roomId: UUID,
    val purchaseYear: Int,
    val status: String
)
EOL
      ;;
    reagent)
      cat > "$ENTITY_FILE" <<EOL
package domain.$DOMAIN

import java.util.UUID
import java.time.LocalDate

data class ${DOMAIN_CAP}Entity(
    val id: UUID,
    val name: String,
    val type: String,
    val quantity: Double,
    val unit: String,
    val roomId: UUID,
    val expirationDate: LocalDate
)
EOL
      ;;
    user)
      cat > "$ENTITY_FILE" <<EOL
package domain.$DOMAIN

import java.util.UUID

data class ${DOMAIN_CAP}Entity(
    val id: UUID,
    val username: String,
    val email: String,
    val passwordHash: String,
    val researcherId: UUID
)
EOL
      ;;
    role)
      cat > "$ENTITY_FILE" <<EOL
package domain.$DOMAIN

import java.util.UUID

data class ${DOMAIN_CAP}Entity(
    val id: UUID,
    val name: String,
    val description: String?
)
EOL
      ;;
    permission)
      cat > "$ENTITY_FILE" <<EOL
package domain.$DOMAIN

import java.util.UUID

data class ${DOMAIN_CAP}Entity(
    val id: UUID,
    val name: String,
    val description: String?
)
EOL
      ;;
    researcherExchange)
      cat > "$ENTITY_FILE" <<EOL
package domain.$DOMAIN

import java.util.UUID
import java.time.LocalDate

data class ${DOMAIN_CAP}Entity(
    val id: UUID,
    val researcherId: UUID,
    val hostUniversityId: UUID,
    val hostInstituteId: UUID,
    val exchangeType: String,
    val status: String,
    val startDate: LocalDate,
    val endDate: LocalDate?
)
EOL
      ;;
    publication)
      cat > "$ENTITY_FILE" <<EOL
package domain.$DOMAIN

import java.util.UUID
import java.time.LocalDate

data class ${DOMAIN_CAP}Entity(
    val id: UUID,
    val title: String,
    val abstract: String?,
    val publicationType: String,
    val journalOrPublisher: String?,
    val doi: String?,
    val publicationDate: LocalDate?,
    val scientificFieldId: UUID
)
EOL
      ;;
    grant)
      cat > "$ENTITY_FILE" <<EOL
package domain.$DOMAIN

import java.util.UUID
import java.math.BigDecimal
import java.time.LocalDate

data class ${DOMAIN_CAP}Entity(
    val id: UUID,
    val title: String,
    val description: String?,
    val grantNumber: String,
    val startDate: LocalDate,
    val endDate: LocalDate?,
    val totalAmount: BigDecimal,
    val currency: String,
    val agencyId: UUID,
    val scientificFieldId: UUID
)
EOL
      ;;
  esac
done

echo "✅ Domain entities fully aligned with Exposed tables created!"
