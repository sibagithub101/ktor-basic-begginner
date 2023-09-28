package com.example


import com.example.plugins.routes.homeRoutes
import com.example.plugins.routes.getMethodRoutes
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.routing.*

fun main(){
    embeddedServer(factory = Netty, port = 8080, host = "0.0.0.0", module = Application::applicationModule).start(true)
}

fun Application.applicationModule() {
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
