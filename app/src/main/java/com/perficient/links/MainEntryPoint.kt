package com.perficient.links

import android.app.Application
import android.os.Bundle
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainEntryPoint: Application() {

    // Se registran todas las biblioteca de analitycs:
//      New Relic
//      https://docs.newrelic.com/docs/mobile-monitoring/new-relic-mobile-android/android-sdk-api/android-sdk-api-guide/
//
//      Tealium
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate()
//        registerActivityLifecycleCallbacks()
//    }
}