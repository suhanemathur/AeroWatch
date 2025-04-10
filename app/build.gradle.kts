plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.example.aerowatch"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.aerowatch"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
        // JUnit and Testing
    testImplementation("junit:junit:4.13.2")  // JUnit4
    androidTestImplementation("androidx.test.ext:junit:1.1.3")  // AndroidX JUnit Extension
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")  // Espresso for UI Testing
    androidTestImplementation("androidx.test:core:1.4.0")  // Core AndroidX testing library
    androidTestImplementation("androidx.test:runner:1.4.0")  // Runner for instrumented tests

    // Jetpack Compose dependencies
    implementation(platform("androidx.compose:compose-bom:2025.03.01")) // Use the correct version of BOM

    // Compose dependencies
    implementation("androidx.compose.ui:ui:1.5.0")  // Ensure the Compose UI version is updated
    implementation("androidx.compose.material:material:1.5.0")  // Use the same version across components
    implementation("androidx.compose.material3:material3:1.0.0")

    // ViewModel and LiveData dependencies
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")  // Updated version
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")  // Updated version

    // Navigation for Compose
    implementation("androidx.navigation:navigation-compose:2.5.0")  // Make sure Navigation is updated

    // Room dependencies
//    implementation("androidx.room:room-runtime:2.4.0")
//    implementation("androidx.room:room-ktx:2.4.0")
    implementation(libs.androidx.runtime.livedata)
//    kapt("androidx.room:room-compiler:2.4.0")

    // Retrofit dependencies
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.google.code.gson:gson:2.8.8")

    // Coroutines & WorkManager
    implementation("androidx.work:work-runtime-ktx:2.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")

    // Lifecycle dependencies
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")

    // Core Android libraries
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.5.0")
    implementation("com.google.android.material:material:1.6.0")
}
