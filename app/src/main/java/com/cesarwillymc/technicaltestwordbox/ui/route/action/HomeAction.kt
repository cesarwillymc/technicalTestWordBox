package com.cesarwillymc.technicaltestwordbox.ui.route.action

import androidx.navigation.NavHostController
import com.cesarwillymc.technicaltestwordbox.domain.usecase.people.entities.Person
import com.cesarwillymc.technicaltestwordbox.extension.toJson
import com.cesarwillymc.technicaltestwordbox.ui.route.HomeRoute

class HomeAction(navController: NavHostController) {

    val upPress: () -> Unit = {
        navController.navigateUp()
    }

    val navigateToHome: () -> Unit = {
        navController.navigate(HomeRoute.Home.path)
    }

    val navigateToDetail: (Person) -> Unit = { model ->
        val modelArgs =  toJson(model)
        val routeReplace = HomeRoute.Detail.path.replace(
            "{$MODEL_PEOPLE_ARGS}",
            modelArgs
        )
        navController.navigate(routeReplace)
    }

    companion object {
        const val MODEL_PEOPLE_ARGS = "peopleArg"
    }
}
