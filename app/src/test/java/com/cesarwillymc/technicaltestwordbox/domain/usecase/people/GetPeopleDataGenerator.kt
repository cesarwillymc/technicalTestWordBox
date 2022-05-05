package com.cesarwillymc.technicaltestwordbox.domain.usecase.people

import com.cesarwillymc.technicaltestwordbox.domain.usecase.people.entities.Person

/**
 * Created by cesarwillymamanicanaza on 4/05/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
object GetPeopleDataGenerator {
    val listPeople = listOf(
        Person(
            "Cesar", "idi", "www.google.com", "cesarwilly.mc@gmail.com", "male", 23, "Peru"
        )
    )

    val errorData = Exception("Sucedio un error")
}