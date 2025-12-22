package infrastructure.auth.model.command

import io.ktor.server.auth.jwt.JWTPrincipal

data class MeCommand(val principal: JWTPrincipal)