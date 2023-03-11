package com.sovostyanov.application.rest

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.sovostyanov.application.config.Config
import com.sovostyanov.application.repo.students

fun Route.groupRoutes(){
    route(Config.groupsPath){
        get {
            val groups = students.map { it.group }.toSet()
            if (groups.isEmpty()){
                call.respondText("No groups found", status = HttpStatusCode.NotFound)
            } else {
                call.respond(groups)
            }
        }
    }
}