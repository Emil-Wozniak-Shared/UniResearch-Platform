package infrastructure.auth.port.`in`.http

import infrastructure.auth.model.command.LoginCommand
import infrastructure.auth.model.command.MeCommand
import infrastructure.auth.model.response.MeResponse
import infrastructure.auth.model.result.LoginResult

interface AuthHttpPort {
    suspend fun login(command: LoginCommand): LoginResult
    suspend fun me(command: MeCommand): MeResponse
}