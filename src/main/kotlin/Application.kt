package pl.ejdev

import configureDatabases
import configureFrameworks
import configureSecurity
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureHTTP()
    configureSecurity()
    configureMonitoring()
    configureTemplating()
    configureFrameworks()
    configureDatabases()
    configureSockets()
    configureRouting()
}
