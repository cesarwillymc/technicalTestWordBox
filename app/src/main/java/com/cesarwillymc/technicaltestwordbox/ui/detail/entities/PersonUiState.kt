package com.cesarwillymc.technicaltestwordbox.ui.detail.entities

import com.cesarwillymc.technicaltestwordbox.domain.usecase.people.entities.Person

/**
 * Created by cesarwillymamanicanaza on 28/04/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
data class PersonUiState(
    val isLoading: Boolean = false,
    val isComplete: Boolean = false,
    val isError: Boolean = false,
    val person: Person ?= null
)
