package com.sovostyanov.application.repo

import com.sovostyanov.application.config.Config
import com.sovostyanov.application.data.MenuItem
import com.sovostyanov.application.data.Student

val students: MutableList<Student> = mutableListOf(
    Student("Sheldon", "Cooper", "29m"),
    Student("Leonard", "Hofstadter", "29z"),
    Student("Howard", "Wolowitz", "29m"),
    Student("Penny", "Hofstadter", "29z")
)

val menu: MutableList<MenuItem> = mutableListOf(
    MenuItem("Students" ,Config.studentsPath),
    MenuItem("Groups", Config.groupsPath)
)

