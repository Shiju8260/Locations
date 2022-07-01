/**
 * object class for gradle dependencies used in this project
 */
object Libraries {

    //androidx support
    const val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
    const val androidxAppCompat =
        "androidx.appcompat:appcompat:${Versions.androidxAppCompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val livedata =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.liveData}"
    const val viewmodel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModel}"

    //coroutines and retrofit
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    const val okHttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"
    const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutinesVersion}"
    const val retrofitOkhttp =
        "com.jakewharton.retrofit:retrofit1-okhttp3-client:${Versions.retrofitHttpVersion}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitGsonConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"


    //material design
    const val materialDesign = "com.google.android.material:material:${Versions.material}"

    //Coil image loader
    const val coil = "io.coil-kt:coil:${Versions.coilVersion}"

    //Navigation Architecture
    const val navigationArchFragment =
        "android.arch.navigation:navigation-fragment-ktx:${Versions.navigationArchitectureVersion}"
    const val navigation =
        "android.arch.navigation:navigation-ui-ktx:${Versions.navigationArchitectureVersion}"

    //Hilt
    const val daggerHiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val daggerHiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"

    //Junit test cases
    const val junit = "junit:junit:${Versions.junitVersion}"
    const val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunit}"
    const val androidxEspresso =
        "androidx.test.espresso:espresso-core:${Versions.androidxEspresso}"

    const val coroutineTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTestVersion}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockitoCore}"
    const val androidXCoreTest =
        "androidx.arch.core:core-testing:${Versions.androidArchCoreTesting}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockitoWebServer}"
    const val mockInline = "org.mockito:mockito-inline:${Versions.mockitoInlineVersion}"

    const val buildGradle = "com.android.tools.build:gradle:${Versions.gradleVersion}"
    const val kotlinVersion = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val navigationSafeArgs =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationSafeArgsVersion}"
    const val daggerHiltGradle =
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}"
}