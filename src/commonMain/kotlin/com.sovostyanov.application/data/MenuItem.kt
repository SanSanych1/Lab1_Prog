package com.sovostyanov.application.data

import kotlinx.serialization.Serializable

@Serializable
class MenuItem(
    val displayName: String,
    val path: String
)