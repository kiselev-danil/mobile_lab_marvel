package com.example.marvel.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marvel.components.CharacterScreen
import com.example.marvel.components.ChooseYourHeroScreen

@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {

    NavHost(
        navController = navController,
        startDestination = NavRoutes.ChooseYourHeroScreen.toString()
    ) {
        composable(route = NavRoutes.ChooseYourHeroScreen.toString()) {
            ChooseYourHeroScreen(
                onCharacterSelect = { id -> navController.navigate(NavRoutes.CharacterScreen.toString() + "/" + id) }
            )
        }
        composable(route = NavRoutes.CharacterScreen.toString() + "/{modelId}") { backStackEntry ->
            CharacterScreen(
                modelId = backStackEntry.arguments?.getString("modelId")
                    ?: throw Exception("Cannot get nav param"),
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}