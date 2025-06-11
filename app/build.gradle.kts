plugins {
    alias(libs.plugins.androidApplication)   // because android-application -> androidApplication
    alias(libs.plugins.kotlinAndroid)        // kotlin-android -> kotlinAndroid
    alias(libs.plugins.kotlinCompose)        // kotlin-compose -> kotlinCompose
    alias(libs.plugins.kotlinKapt)            // kotlin-kapt -> kotlinKapt
    alias(libs.plugins.hilt)                   // hilt -> hilt
}

android {
    namespace = "com.example.inventorymanager"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.inventorymanager"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // For Material 3
    implementation("androidx.compose.material3:material3:1.2.0")

    // Core Compose libraries
    implementation("androidx.compose.ui:ui:1.5.1")
    implementation("androidx.compose.ui:ui-tooling-preview:1.5.1")

    // For Compose Activity integration
    implementation("androidx.activity:activity-compose:1.7.2")
    // Jetpack Compose
    implementation("androidx.compose.ui:ui:1.5.1")
    implementation("androidx.compose.runtime:runtime-livedata:1.5.1")

// Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    // Hilt core
    implementation("com.google.dagger:hilt-android:2.46.1") // Use latest version
// Hilt ViewModel integration with Jetpack ViewModel
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03") // (Deprecated but still used in older projects)

    implementation("androidx.compose.material:material:1.5.1")
    implementation(libs.androidx.core.ktx)
    implementation("com.google.dagger:dagger:2.24")
    implementation("com.google.dagger:hilt-android:2.50")
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}