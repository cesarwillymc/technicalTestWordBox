package com.cesarwillymc.technicaltestwordbox.ui.home.entities

import com.cesarwillymc.technicaltestwordbox.domain.usecase.people.entities.Person

/**
 * Created by cesarwillymamanicanaza on 28/04/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
data class PeopleUiState(
    val isLoading: Boolean = false,
    val isComplete: Boolean = false,
    val isError: Boolean = false,
    val people: List<Person> = listOf()
)
