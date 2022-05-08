package com.kraftanapp.askanything

sealed class Routes(val route: String) {
    object Login : Routes("Login")
    object Dashboard : Routes("Dashboard")
    object Transfer : Routes("Transfer")
    object StandingOrder : Routes("StandingOrder")
}