package infrastructure.auth.port.`in`.http

import infrastructure.auth.model.command.LoginCommand
import infrastructure.auth.model.result.LoginResult

interface AuthHttpPort {
    suspend fun login(command: LoginCommand): LoginResult
}