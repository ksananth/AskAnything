package com.kraftanapp.askanything

sealed class Routes(val route: String) {
    object Login : Routes("Login")
    object Dashboard : Routes("Dashboard")
    object Transfer : Routes("Transfer")
    object StandingOrder : Routes("StandingOrder")
    object DirectDebit : Routes("DirectDebit")
    object Cards : Routes("cards")
    object Beneficiary : Routes("Beneficiary")
    object Contact : Routes("Contact")
}