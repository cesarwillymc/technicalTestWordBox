package com.cesarwillymc.technicaltestwordbox.ui.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import com.cesarwillymc.technicaltestwordbox.ui.base.GreenFullScreenLoading
import com.cesarwillymc.technicaltestwordbox.ui.detail.component.DetailContent
import com.cesarwillymc.technicaltestwordbox.ui.detail.viewmodel.DetailViewModel

/**
 * Created by cesarwillymamanicanaza on 28/04/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
@ExperimentalComposeUiApi
@Composable
fun DetailScreen(
    onNavigateUp: () ->Unit,
    detailViewModel: DetailViewModel
) {
    val personUiState by detailViewModel.personUiState.collectAsState()

    GreenFullScreenLoading(personUiState.isLoading)

    DetailContent(onNavigateUp = onNavigateUp, person = personUiState.person )
}