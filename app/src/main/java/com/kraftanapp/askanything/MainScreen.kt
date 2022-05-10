package com.kraftanapp.askanything

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kraftanapp.askanything.feature.beneficiary.BeneficiaryScreen
import com.kraftanapp.askanything.feature.cards.CardScreen
import com.kraftanapp.askanything.feature.contacts.ContactScreen
import com.kraftanapp.askanything.feature.dashboard.DashboardScreen
import com.kraftanapp.askanything.feature.directdebit.DirectDebitScreen
import com.kraftanapp.askanything.feature.login.LoginScreen
import com.kraftanapp.askanything.feature.sto.StandingOrderScreen
import com.kraftanapp.askanything.feature.transfer.TransferScreen

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
        composable(Routes.DirectDebit.route) {
            DirectDebitScreen(navController = navController)
        }
        composable(Routes.Cards.route) {
            CardScreen(navController = navController)
        }
        composable(Routes.Contact.route) {
            ContactScreen(navController = navController)
        }
        composable(Routes.Beneficiary.route) {
            BeneficiaryScreen(navController = navController)
        }
    }
}
