package com.example.plugins.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable
import java.io.File

fun Route.getMethodRoutes(){
    get ("/getUserDetails") {
        val userInfo =  call.receive<LoginModel>()
        call.respond(HttpStatusCode.OK,UserResponse(0, userInfo.email, userInfo.password))
        /**
         * when user getting response body format of json object that case
         * we pass model/data class inside call.respond()
         */
    }
    /**
     * the below code used for attached data in header
     */
    get("/headers"){
        call.response.headers.append("server-name","ktor-server")
        call.response.headers.append("chocolate","kitkat")
        call.respondText("Header Attached")
    }
    /**
     * File Download it's working on web browser
     */
    get("/fileDownload"){
    val file = File("files/img2.png")
        call.response.header(
            HttpHeaders.ContentDisposition,
            ContentDisposition.Attachment.withParameter(
                ContentDisposition.Parameters.FileName,"getDownloadImg.png"
            ).toString()
        )
        call.respondFile(file)
        call.respondText("File Downloading....!!!")
    }

    /**
     * File Open it's working on web browser
     */
    get("/openFile"){
    val file = File("files/img1.png")
        call.response.header(
            HttpHeaders.ContentDisposition,
            ContentDisposition.Inline.withParameter(
                ContentDisposition.Parameters.FileName,"openImg.png"
            ).toString()
        )
        call.respondFile(file)
    }
}



@Serializable
data class UserResponse(
    val status:Int?=null,
    val email: String?=null,
    val password:String?=null
)