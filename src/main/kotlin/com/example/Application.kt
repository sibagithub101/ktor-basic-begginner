package com.example


import com.example.plugins.routes.homeRoutes
import com.example.plugins.routes.getMethodRoutes
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    /**
     * below code used for install ContentNegotiation for Serializable of json object
     */
    install(ContentNegotiation){
        json()
    }
    /**
     * below code used for Install/Configure Routes
     */
   routing {
       homeRoutes()
       getMethodRoutes()
   }
}
