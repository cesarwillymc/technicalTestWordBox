package com.cesarwillymc.technicaltestwordbox.ui.route.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cesarwillymc.technicaltestwordbox.ui.detail.DetailScreen
import com.cesarwillymc.technicaltestwordbox.ui.home.HomeScreen
import com.cesarwillymc.technicaltestwordbox.ui.route.HomeRoute
import com.cesarwillymc.technicaltestwordbox.ui.route.action.HomeAction

@ExperimentalComposeUiApi
@SuppressWarnings("LongMethod")
@Composable
fun GreenCrossNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String,
) {
    // Actions Route
    val homeActions = remember(navController) { HomeAction(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(HomeRoute.Home.path) {
            HomeScreen(
                onNavigateDetail = homeActions.navigateToDetail,
            )
        }

        composable(HomeRoute.Detail.path) {
            DetailScreen(
                onNavigateUp = homeActions.upPress,
                detailViewModel = hiltViewModel()
            )
        }
    }
}
