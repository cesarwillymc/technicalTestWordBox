package com.cesarwillymc.technicaltestwordbox.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.cesarwillymc.technicaltestwordbox.ui.theme.GreenCrossTheme

/**
 * Created by cesarwillymamanicanaza on 28/04/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreenCrossTheme {

            }
        }
    }
}
