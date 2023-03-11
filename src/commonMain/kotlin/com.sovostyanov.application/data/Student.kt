package com.sovostyanov.application.data

import kotlinx.serialization.Serializable

@Serializable
class Student(
    val firstname: String,
    val surname: String,
    val group: String
){
    fun fullname() =
        "$firstname $surname"
}