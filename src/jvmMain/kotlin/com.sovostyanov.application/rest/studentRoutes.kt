package com.sovostyanov.application.rest

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.sovostyanov.application.config.Config
import com.sovostyanov.application.repo.students

fun Route.studentRoutes(){
    route(Config.studentsPath){
        get {
            if (students.isEmpty()){
                call.respondText("No students found", status = HttpStatusCode.NotFound)
            } else {
                call.respond(students)
            }
        }
    }
}