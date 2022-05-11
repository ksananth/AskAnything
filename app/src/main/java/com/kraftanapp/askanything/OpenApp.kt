package com.kraftanapp.askanything

sealed class OpenApp {
    data class Shortcut(val feature: Feature) : OpenApp()
    object Normally: OpenApp()
}