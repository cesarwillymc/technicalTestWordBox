package com.cesarwillymc.technicaltestwordbox.ui.home.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.cesarwillymc.technicaltestwordbox.domain.usecase.people.GetPeopleRandomUseCase
import com.cesarwillymc.technicaltestwordbox.extension.getData
import com.cesarwillymc.technicaltestwordbox.extension.getError
import com.cesarwillymc.technicaltestwordbox.extension.isError
import com.cesarwillymc.technicaltestwordbox.extension.isSuccess
import com.cesarwillymc.technicaltestwordbox.ui.home.entities.PeopleUiState
import com.cesarwillymc.technicaltestwordbox.ui.utils.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

/**
 * Created by cesarwillymamanicanaza on 28/04/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPeopleRandomUseCase: GetPeopleRandomUseCase
) : ViewModel() {
    val peopleUiState get() = _peopleUiState.asStateFlow()
    private val _peopleUiState = MutableStateFlow(PeopleUiState())

    init {
        onLoadPeople()
    }

    private fun onLoadPeople() {
        _peopleUiState.update { PeopleUiState(isLoading = true) }
        launch {
            getPeopleRandomUseCase(Unit).let { result ->
                when {
                    result.isError -> {
                        _peopleUiState.update { PeopleUiState(isError = true) }
                        Log.e("onLoadPeople", " error  ${result.getError()}")
                    }
                    result.isSuccess -> {
                        _peopleUiState.update {
                            PeopleUiState(isComplete = true, people = result.getData())
                        }
                    }
                }
            }
        }
    }
}