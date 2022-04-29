package com.cesarwillymc.technicaltestwordbox.ui

import androidx.lifecycle.ViewModel
import com.cesarwillymc.technicaltestwordbox.data.util.network.ConnectionUtils
import com.cesarwillymc.technicaltestwordbox.extension.REPEAT_1000
import com.cesarwillymc.technicaltestwordbox.extension.TIME_DELAY_4000
import com.cesarwillymc.technicaltestwordbox.ui.utils.launch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * Created by cesarwillymamanicanaza on 12/03/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val connectionUtils: ConnectionUtils
) : ViewModel() {
    val hasInternet get() = _hasInternet.asStateFlow()
    private val _hasInternet = MutableStateFlow(false)

    init {
        onLoadInternet()
    }

    private fun onLoadInternet() {
        launch {
            repeat(REPEAT_1000) {
                _hasInternet.value = connectionUtils.isNetworkAvailable()
                delay(TIME_DELAY_4000)
            }
        }
    }
}
