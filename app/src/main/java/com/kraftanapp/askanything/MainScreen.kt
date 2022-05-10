package com.kraftanapp.askanything

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kraftanapp.askanything.dashboard.DashboardScreen
import com.kraftanapp.askanything.login.LoginScreen
import com.kraftanapp.askanything.sto.StandingOrderScreen
import com.kraftanapp.askanything.transfer.TransferScreen

@Composable
fun ScreenMain() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Login.route) {
        composable(Routes.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(Routes.Dashboard.route) {
            DashboardScreen(navController = navController)
        }
        composable(Routes.Transfer.route) {
            TransferScreen(navController = navController)
        }
        composable(Routes.StandingOrder.route) {
            StandingOrderScreen(navController = navController)
        }
    }
}
