package pl.ejdev

import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureHTTP()
    configureSecurity()
    configureMonitoring()
    configureTemplating()
    configureDatabases()
    configureFrameworks()
    configureSockets()
    configureRouting()
}
