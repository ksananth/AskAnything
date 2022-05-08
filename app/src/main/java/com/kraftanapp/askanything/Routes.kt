package com.kraftanapp.askanything

sealed class Routes(val route: String) {
    object Login : Routes("Login")
}