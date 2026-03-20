package com.example.carmaps.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.carmaps.presentation.catalog.CatalogScreen
import com.example.carmaps.presentation.map.MapScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.CatalogScreen.route
    ) {
        composable(route = Screen.CatalogScreen.route) {
            CatalogScreen(
                onItemClicked = { lat, lon ->
                    navController.navigate(Screen.MapScreen.createArg(lat, lon))
                }
            )
        }

        composable(
            route = Screen.MapScreen.route,
            arguments = Screen.MapScreen.args
        ) {
            MapScreen()
        }
    }
}