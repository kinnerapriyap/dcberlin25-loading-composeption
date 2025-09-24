package com.kinnerapriyap.loading_composeption

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import androidx.savedstate.SavedState
import androidx.savedstate.read
import androidx.savedstate.write
import com.kinnerapriyap.loading_composeption.screens.ConclusionsScreen
import com.kinnerapriyap.loading_composeption.screens.HomeScreen
import com.kinnerapriyap.loading_composeption.screens.Scenario
import com.kinnerapriyap.loading_composeption.screens.ScenarioDetailScreen
import com.kinnerapriyap.loading_composeption.screens.ScenarioListScreen
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf
import kotlinx.serialization.json.Json

sealed interface Screen {
    @Serializable
    object Home : Screen

    @Serializable
    object Scenarios : Screen

    @Serializable
    data class ScenarioDetail(val scenario: Scenario) : Screen

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
                onScenarioSelected = { scenario -> navController.navigate(Screen.ScenarioDetail(scenario)) }
            )
        }
        composable<Screen.ScenarioDetail>(
            typeMap = mapOf(typeOf<Scenario>() to ScenarioParameterType)
        ) { entry ->
            val args = entry.toRoute<Screen.ScenarioDetail>()
            ScenarioDetailScreen(
                scenario = args.scenario,
                onBack = { navController.popBackStack() }
            )
        }
        composable<Screen.Conclusions> {
            ConclusionsScreen(onBack = { navController.popBackStack() })
        }
    }
}

internal val ScenarioParameterType = object : NavType<Scenario>(isNullableAllowed = false) {
    override fun put(
        bundle: SavedState,
        key: String,
        value: Scenario
    ) {
        bundle.write { putString(key, serializeAsValue(value)) }
    }

    override fun get(
        bundle: SavedState,
        key: String
    ): Scenario = bundle.read { parseValue(getString(key)) }

    override fun parseValue(value: String): Scenario = Json.decodeFromString(value)

    override fun serializeAsValue(value: Scenario): String = Json.encodeToString(value)
}
