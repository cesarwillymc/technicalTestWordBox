package com.cesarwillymc.technicaltestwordbox.ui.detail.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.cesarwillymc.technicaltestwordbox.extension.fromJson
import com.cesarwillymc.technicaltestwordbox.ui.detail.entities.PersonUiState
import com.cesarwillymc.technicaltestwordbox.ui.route.action.HomeAction
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
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val personUiState get() = _personUiState.asStateFlow()
    private val _personUiState = MutableStateFlow(PersonUiState())

    init {
        onParseArgument(savedStateHandle.get<String>(HomeAction.MODEL_PEOPLE_ARGS))
    }

    private fun onParseArgument(argument: String?) {
        _personUiState.update {
            PersonUiState(isLoading = true)
        }
        argument?.let { arg ->
            _personUiState.update {
                PersonUiState(isComplete = true, person = fromJson(arg))
            }
        }
    }
}