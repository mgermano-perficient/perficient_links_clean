package dependencies

object Versions {

    const val versionCode = 1
    const val versionName = "1.0"
    const val compileSdk = 33
    const val minSdk = 21
    const val targetSdk = 33

    object SupportAndroidLibs {
        const val gradle = "7.2.1"
        const val androidxAppCompat         = "1.4.1"          //"1.6.0"
        const val androidxCoreKtx           = "1.7.0"
        const val androidxFragmentKtx       = "1.4.1"          //"1.3.6"
        const val androidxActivityKtx       = "1.4.0"
        const val androidxConstraintLayout  = "2.1.4"
        const val material                  = "1.7.0"
    }

    object Testing {
          const val espresso = "3.5.1"
          const val junit = "4.13.2"
          const val junitPlatform = "1.1.5"
    }

    object DroLibraries {

        // RecyclerView
        const val recyclerView = "1.1.0"

        // CardView
        const val cardView = "1.0.0"

        // Hilt
        const val daggerHiltAndroid               = "2.40"
        const val daggerHiltCompiler              = "2.40"
        const val hiltDroGradlePlugin             = "2.40"

        // Glide
        const val glide = "4.10.0"

        // Lifecycle
        const val androidxLifecycleViewModelKtx          = "2.4.1"
        const val androidxLifecycleRuntimeKtx            = "2.4.1"
        const val androidxLifecycleViewModelSavedStated  = "2.4.1"

        // Livedata
        const val androidxLifecycleLivedataKtx = "2.4.1"

        // Coroutines
        const val coroutinesCore    = "1.3.0"
        const val coroutinesAndroid = "1.3.0"

        // Retrofit
        const val retrofit2               = "2.6.0"
        const val retrofit2ConverterGson  = "2.6.0"

        // GSON
        const val gson = "2.8.5"
    }
}
