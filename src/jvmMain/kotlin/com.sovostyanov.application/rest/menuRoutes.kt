package com.sovostyanov.application.rest

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.sovostyanov.application.config.Config
import com.sovostyanov.application.repo.menu
import com.sovostyanov.application.repo.students

fun Route.menuRoutes(){
    route("menu/"){
        get {
            if (menu.isEmpty()){
                call.respondText("No groups found", status = HttpStatusCode.NotFound)
            } else {
                call.respond(menu)
            }
        }
    }
}