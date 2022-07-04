plugins {
    id("com.android.library")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = Configs.compileSdk

    defaultConfig {
        minSdk = Configs.minSdk
        targetSdk = Configs.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            // etc.
        }
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
    buildFeatures {
        dataBinding = true
    }
}

dependencies {

    implementation(project(Models.domain))

    implementation (Libraries.okHttp)
    implementation (Libraries.okHttpLoggingInterceptor)
    implementation (Libraries.coroutines)
    implementation (Libraries.retrofitOkhttp)
    implementation (Libraries.retrofit)
    implementation (Libraries.retrofitGsonConverter)

    //Hilt
    implementation ( Libraries.daggerHiltAndroid)
    kapt (Libraries.daggerHiltCompiler)


    testImplementation(Libraries.junit)
    androidTestImplementation(Libraries.androidxJunit)
    androidTestImplementation(Libraries.androidxEspresso)

    testImplementation (Libraries.coroutineTest)
    testImplementation (Libraries.mockitoCore)
    testImplementation (Libraries.androidXCoreTest)
    testImplementation (Libraries.mockWebServer)
    testImplementation (Libraries.mockInline)
}