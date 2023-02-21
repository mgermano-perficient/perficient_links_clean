package dependencies

object Dependencies {

    const val gradle = "com.android.tools.build:gradle:${Versions.SupportAndroidLibs.gradle}"

    // The Support Android Libraries
    const val androidxCoreKtx          = "androidx.core:core-ktx:${Versions.SupportAndroidLibs.androidxCoreKtx}"
    const val androidxAppCompat        = "androidx.appcompat:appcompat:${Versions.SupportAndroidLibs.androidxAppCompat}"
    const val androidxActivityKtx      = "androidx.activity:activity-ktx:${Versions.SupportAndroidLibs.androidxActivityKtx}"
    const val androidxFragmentKtx      = "androidx.fragment:fragment-ktx:${Versions.SupportAndroidLibs.androidxFragmentKtx}"
    const val googleAndroidMaterial    = "com.google.android.material:material:${Versions.SupportAndroidLibs.material}"
    const val androidxConstraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.SupportAndroidLibs.androidxConstraintLayout}"

    // Testing Libraries
    const val junit = "junit:junit:${Versions.Testing.junit}"
    const val androidxTestExt = "androidx.test.ext:${Versions.Testing.junitPlatform}"
    const val androidxTestExpressoCore = "androidx.test.espresso:espresso-core:${Versions.Testing.espresso}"

    // ***************************
    //      Android Libraries
    // ***************************

    // RecyclerView & CardView
    const val recyclerview = "androidx.recyclerview:recyclerview:${Versions.DroLibraries.recyclerView}"
    const val cardview = "androidx.cardview:cardview:${Versions.DroLibraries.cardView}"

    // LifeCycle
    const val androidxLifecycleViewModelKtx          = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.DroLibraries.androidxLifecycleViewModelKtx}"
    const val androidxLifecycleRuntimeKtx            = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.DroLibraries.androidxLifecycleRuntimeKtx}"
    const val androidxLifecycleViewModelSavedStated  = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.DroLibraries.androidxLifecycleViewModelSavedStated}"

    // LiveData
    const val androidxLifecycleLivedataKtx   = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.DroLibraries.androidxLifecycleLivedataKtx}"

    // Hilt
    const val daggerHiltAndroidGradlePlugin     = "com.google.dagger:hilt-android-gradle-plugin:${Versions.DroLibraries.hiltDroGradlePlugin}"
    const val daggerHiltAndroid                 = "com.google.dagger:hilt-android:${Versions.DroLibraries.daggerHiltAndroid}"
    const val daggerHiltCompiler                = "com.google.dagger:hilt-android-compiler:${Versions.DroLibraries.daggerHiltCompiler}"   // kapt

    // Glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.DroLibraries.glide}"

    // Coroutines
    const val coroutinesCore    = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.DroLibraries.coroutinesCore}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.DroLibraries.coroutinesAndroid}"

    // Retrofit
    const val retrofit2                 = "com.squareup.retrofit2:retrofit:${Versions.DroLibraries.retrofit2}"
    const val retrofit2ConverterGson    = "com.squareup.retrofit2:converter-gson:${Versions.DroLibraries.retrofit2ConverterGson}"

    // GSON
    const val gson  = "com.google.code.gson:gson:${Versions.DroLibraries.gson}"
}
