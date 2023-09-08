package com.example.plugins

import com.example.LoginModel
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

/**
 * Getting headerName,User-Agent,Accept and query parameter's push name
 * */
fun Route.homeRoutes() {
    route("/"){
        get {
            // Api format:- http://127.0.0.1:8080?name=siba&email=siba@gmail.com
            println("Uri: ${call.request.uri}")  //output  /
            println("Header: ${call.request.headers.names()}")
            println("User-Agent: ${call.request.headers["User-Agent"]}")
            println("Accept: ${call.request.headers["Accept"]}")
            println("Query params: ${call.request.queryParameters.names()}")
            println("Name: ${call.request.queryParameters["name"]}")
            println("Email: ${call.request.queryParameters["email"]}")

            call.respondText("Hello-Ktor-world")
        }
    }

    /**
     *  getting page number from (parameters)
     *
     *  we can use <b>route</b> for declare end point or
     *  without use route we can declare end point inside get/post method
     */
    route("/mobiles"){
        // Api format:-  http://127.0.0.1:8080/mobiles/5
        get("/mobiles/{page}") {
            call.respondText("you are on page number:${call.parameters["page"]}")
        }

    }
    /**
     * post method for getting usr data and send response
     */

    post("/login") {
      val userInfo =  call.receive<LoginModel>()
        println(userInfo)
        call.respondText("Login successful")
    }

}


