package dependencies

object Versions {

    const val versionCode = 1
    const val versionName = "1.0"
    const val compileSdk = 33
    const val minSdk = 21
    const val targetSdk = 33

    object SupportAndroidLibs {
         const val gradle = "7.2.1"
         const val androidxAppCompat = "1.6.0"
         const val androidxCoreKtx = "1.7.0"
         const val androidxConstraintLayout = "2.1.4"
         const val material = "1.7.0"
    }

    object Testing {
          const val espresso = "3.5.1"
          const val junit = "4.13.2"
          const val junitPlatform = "1.1.5"
    }

    object droLibraries {

        // RecyclerView
        const val recyclerView = "1.1.0"

        // CardView
        const val cardView = "1.0.0"

        // Hilt
        const val hilt = "2.40.5"
        const val hiltCompiler = "2.40.5"
    }
}
