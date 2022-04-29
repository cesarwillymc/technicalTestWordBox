package com.cesarwillymc.technicaltestwordbox.domain.usecase.people.entities

/**
 * Created by cesarwillymamanicanaza on 28/04/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
data class People(
    val name: String,
    val id: String,
    val photo: String,
    val email: String,
    val gender: String,
    val age: Int,
    val country: String
)
