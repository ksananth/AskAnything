package com.kraftanapp.askanything

object SessionRepository {

    fun loggedIn() {
        isLoggedIn = true
    }

    fun logOut() {
        isLoggedIn = false
    }

    var isLoggedIn = false
}