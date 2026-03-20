package com.example.carmaps.presentation.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(val route: String, val args: List<NamedNavArgument>) {
    object CatalogScreen : Screen(
        route = "catalog",
        args = listOf()
    )

    object MapScreen : Screen(
        route = "$map_route/{$lat}/{$lon}",
        args = listOf(
            navArgument(name = lat) { type = NavType.StringType },
            navArgument(name = lon) { type = NavType.StringType }
        )
    ) {
        fun createArg(lat: String, lon: String) = "$map_route/$lat/$lon"
    }

    companion object {
        const val map_route = "map"
        const val lat = "lat"
        const val lon = "lon"
    }
}