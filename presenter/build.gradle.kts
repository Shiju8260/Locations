plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Configs.compileSdk

    defaultConfig {
        minSdk = Configs.minSdk
        targetSdk = Configs.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildFeatures {
        dataBinding = true
    }
    buildTypes {

        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(Models.domain))

    //Coroutines
    implementation(Libraries.coroutines)
    implementation(Libraries.coroutinesCore)

    implementation (Libraries.viewmodel)

    implementation (Libraries.retrofit)
    implementation (Libraries.retrofitGsonConverter)

    //Hilt
    implementation ( Libraries.daggerHiltAndroid)
    kapt (Libraries.daggerHiltCompiler)


    //coil for image rendering
    implementation (Libraries.coil)

    implementation (Libraries.navigationArchFragment)
    implementation (Libraries.navigation)

    implementation(Libraries.androidxCore)
    implementation(Libraries.androidxAppCompat)
    implementation(Libraries.materialDesign)

    testImplementation(Libraries.junit)
    androidTestImplementation(Libraries.androidxJunit)
    androidTestImplementation(Libraries.androidxEspresso)
    testImplementation (Libraries.coroutineTest)
    testImplementation (Libraries.mockitoCore)
    testImplementation (Libraries.androidXCoreTest)
    testImplementation (Libraries.mockWebServer)
    testImplementation (Libraries.mockInline)
}