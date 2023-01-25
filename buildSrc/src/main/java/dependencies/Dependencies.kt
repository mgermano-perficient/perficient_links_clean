package dependencies

object Dependencies {

    const val gradle = "com.android.tools.build:gradle:${Versions.SupportAndroidLibs.gradle}"
    const val hiltGradlePlugin  = "com.google.dagger:hilt-android-gradle-plugin:${Versions.droLibraries.hilt}"

    const val androidxCoreKtx   =  "androidx.core:core-ktx:${Versions.SupportAndroidLibs.androidxCoreKtx}"
    const val androidxAppCompat =  "androidx.appcompat:appcompat:${Versions.SupportAndroidLibs.androidxAppCompat}"

    // All The Support Android Libraries are grouped in this supportAndroidLibs array
    val supportAndroidLibs = arrayOf(
        "androidx.core:core-ktx:${Versions.SupportAndroidLibs.androidxCoreKtx}",
        "androidx.appcompat:appcompat:${Versions.SupportAndroidLibs.androidxAppCompat}",
        "com.google.android.material:material:${Versions.SupportAndroidLibs.material}",
        "androidx.constraintlayout:constraintlayout:${Versions.SupportAndroidLibs.androidxConstraintLayout}"
    )

    // All Testing Libraries are grouped in this testingLibs array
    val testingLibs = arrayOf(
        "junit:junit:${Versions.Testing.junit}",
        "androidx.test.ext:${Versions.Testing.junitPlatform}",
        "androidx.test.espresso:espresso-core:${Versions.Testing.espresso}"
    )

    // All Android Libraries are grouped in this droLibraries array
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.droLibraries.recyclerView}"
    const val cardview = "androidx.cardview:cardview:${Versions.droLibraries.cardView}"

    // Hilt
    const val daggerAndroid = "com.google.dagger:hilt-android:${Versions.droLibraries.hilt}"
    const val hiltCompiler  = "com.google.dagger:hilt-compiler:${Versions.droLibraries.hiltCompiler}"

}

