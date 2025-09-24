package com.kinnerapriyap.loading_composeption

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.IntOffset
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.toRoute
import com.kinnerapriyap.loading_composeption.screens.ConclusionsScreen
import com.kinnerapriyap.loading_composeption.screens.HomeScreen
import com.kinnerapriyap.loading_composeption.screens.ScenarioDetailScreen
import com.kinnerapriyap.loading_composeption.screens.ScenarioListScreen
import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    object Home : Screen

    @Serializable
    object Scenarios : Screen

    @Serializable
    data class ScenarioDetail(val id: String) : Screen

    @Serializable
    object Conclusions : Screen
}

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home,
        enterTransition = {
            fadeIn(animationSpec = tween(180)) + slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                tween(180)
            )
        },
        exitTransition = { fadeOut(animationSpec = tween(180)) },
        popEnterTransition = { fadeIn(animationSpec = tween(180)) },
        popExitTransition = {
            fadeOut(animationSpec = tween(180)) + slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                tween(180)
            )
        }
    ) {
        composable<Screen.Home> {
            HomeScreen(
                onViewScenarios = { navController.navigate(Screen.Scenarios) },
                onConclusions = { navController.navigate(Screen.Conclusions) }
            )
        }
        composable<Screen.Scenarios> {
            ScenarioListScreen(
                onBack = { navController.popBackStack() },
                onScenarioSelected = { id -> navController.navigate(Screen.ScenarioDetail(id)) }
            )
        }
        composable<Screen.ScenarioDetail> { entry ->
            val args = entry.toRoute<Screen.ScenarioDetail>()
            ScenarioDetailScreen(
                scenarioName = args.id,
                onBack = { navController.popBackStack() }
            )
        }
        composable<Screen.Conclusions> {
            ConclusionsScreen(onBack = { navController.popBackStack() })
        }
    }
}

