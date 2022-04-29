package com.cesarwillymc.technicaltestwordbox.ui.route

import com.cesarwillymc.technicaltestwordbox.ui.route.action.HomeAction.Companion.MODEL_PEOPLE_ARGS

sealed class HomeRoute(path: String) : Route(path) {
    object Home : HomeRoute("home")
    object Detail : HomeRoute("home/{$MODEL_PEOPLE_ARGS}")
}
