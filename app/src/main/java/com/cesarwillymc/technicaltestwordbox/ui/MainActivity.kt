package com.cesarwillymc.technicaltestwordbox.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.cesarwillymc.technicaltestwordbox.ui.base.WithoutInternetCard
import com.cesarwillymc.technicaltestwordbox.ui.route.HomeRoute
import com.cesarwillymc.technicaltestwordbox.ui.route.graph.GreenCrossNavGraph
import com.cesarwillymc.technicaltestwordbox.ui.theme.GreenCrossTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by cesarwillymamanicanaza on 28/04/22.
 * cesarwilly.mc@gmail.com
 *
 * Lima, Peru.
 */
@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreenCrossTheme {
                ProvideWindowInsets(windowInsetsAnimationsEnabled = true) {
                    val systemUiController = rememberSystemUiController()
                    val mainViewModel: MainViewModel = hiltViewModel()
                    val hasInternet by mainViewModel.hasInternet.collectAsState()

                    /* Side effects */
                    SideEffect {
                        systemUiController.setSystemBarsColor(
                            Color.Transparent,
                            darkIcons = true
                        )
                    }

                    val navController = rememberNavController()
                    Scaffold { paddingValues ->
                        ConstraintLayout(
                            modifier = Modifier
                                .padding(paddingValues)
                                .fillMaxSize()
                        ) {
                            val (body, error) = createRefs()
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .constrainAs(body) {
                                        top.linkTo(parent.top)
                                        bottom.linkTo(if (hasInternet) parent.bottom else error.top)
                                        height = Dimension.fillToConstraints
                                    }
                            ) {
                                GreenCrossNavGraph(
                                    navController = navController,
                                    startDestination = HomeRoute.Home.path,
                                )
                            }
                            if (!hasInternet) {
                                WithoutInternetCard(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .constrainAs(error) {
                                            bottom.linkTo(parent.bottom)
                                        }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
