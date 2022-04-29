package com.cesarwillymc.technicaltestwordbox.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.cesarwillymc.technicaltestwordbox.domain.usecase.people.entities.Person
import com.cesarwillymc.technicaltestwordbox.ui.base.GreenFullScreenLoading
import com.cesarwillymc.technicaltestwordbox.ui.home.component.HomeContent
import com.cesarwillymc.technicaltestwordbox.ui.home.viewmodel.HomeViewModel

/**
 * Created by cesarwillymamanicanaza on 28/04/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
@Composable
fun HomeScreen(
    onNavigateDetail: (Person) -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val peopleUiState by homeViewModel.peopleUiState.collectAsState()

    GreenFullScreenLoading(peopleUiState.isLoading)

    HomeContent(onClickPerson = onNavigateDetail, people = peopleUiState.people)
}
