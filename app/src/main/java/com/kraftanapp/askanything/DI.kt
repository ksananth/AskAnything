package com.kraftanapp.askanything

import org.koin.dsl.module


val demoModule = module {
    single { SessionRepository }
}