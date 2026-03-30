package shibin.kotlix.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.shibin.feature_flow.ui.detail.DetailScreen
import com.shibin.feature_flow.ui.home.FlowHomeScreen
import kotlix.common.AppColors
import shibin.kotlix.core.ModuleRegistry
import shibin.kotlix.views.KotlixHome

// navigation/AppNavigation.kt
sealed class Screen(val route: String) {

    object Home : Screen("home") // Kotlin dashboard

    object FlowHome : Screen("flow/{moduleId}") {
        fun createRoute(moduleId: String) = "flow/$moduleId"
    }

    object FlowDetail : Screen("flow_detail/{operatorId}") {
        fun createRoute(operatorId: String) = "flow_detail/$operatorId"
    }

    object CoroutinesHome : Screen("coroutines/{moduleId}") {
        fun createRoute(moduleId: String) = "coroutines/$moduleId"
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        // 🏠 Kotlin dashboard
        composable(Screen.Home.route) {
            KotlixHome(
                onModuleClick = { moduleId ->

                    when (moduleId) {
                        "flow" -> {
                            navController.navigate(Screen.FlowHome.createRoute(moduleId))
                        }
                        "coroutines" -> {
//                            navController.navigate(Screen.CoroutinesHome.createRoute(moduleId))
                        }
                        "compose" -> { }
                        "state" -> { }
                    }
                }
            )
        }

        // 🌊 Flow Home (your existing screen)
        composable(
            route = Screen.FlowHome.route,
            arguments = listOf(navArgument("moduleId") {
                type = NavType.StringType
            })
        ) { backStackEntry ->

            val moduleId = backStackEntry.arguments?.getString("moduleId") ?: "flow"

            val module = ModuleRegistry.modules.find { it.id == moduleId }

            FlowHomeScreen(
                title = module?.title ?: "Flow",
                subtitle = module?.description ?: "",
                accent = module?.accentColor ?: AppColors.operatorAccentColor(0),
                onBack = { navController.popBackStack() },
                onOperatorClick = { operatorId ->
                    navController.navigate(
                        Screen.FlowDetail.createRoute(operatorId)
                    )
                }
            )
        }

        // 📄 Detail
        composable(
            route = Screen.FlowDetail.route,
            arguments = listOf(
                navArgument("operatorId") { type = NavType.StringType }
            )
        ) { backStackEntry ->

            val operatorId = backStackEntry.arguments?.getString("operatorId") ?: // prevent crash
            return@composable

            DetailScreen(
                onBack = { navController.popBackStack() }
            )
        }
    }
}

